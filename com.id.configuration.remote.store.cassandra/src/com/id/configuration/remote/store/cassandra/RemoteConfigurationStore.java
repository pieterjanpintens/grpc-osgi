/*
 * Copyright 2016 Inventive Designers nv.
 */

package com.id.configuration.remote.store.cassandra;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.id.cassandra.NamedCluster;
import com.id.configuration.proto.Empty;
import com.id.configuration.proto.Level;
import com.id.configuration.proto.NameList;
import com.id.configuration.proto.Option;
import com.id.configuration.proto.Path;
import com.id.configuration.proto.ValueOption;
import com.id.configuration.remote.store.IConfigurationChangeListener;
import com.id.configuration.remote.store.IConfigurationStore;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

/**
 * Store for remote configuration. Uses a cassandra backend.
 * 
 * This store is optimized for reading configuration keys and their values.
 * This store is not optimized for reading all configuration values of a certain level.
 * This was the tradeoff since this operation is not that common.
 * 
 * @author pjpinten
 */
@Component(service = IConfigurationStore.class)
public class RemoteConfigurationStore implements IConfigurationStore, IConfigurationChangeListener
{
	private NamedCluster fCluster = null;
	private Session fSession = null;

	private ConfigurationChangeEventTable fConfigurationChangeEventTable;

	private Thread fSyncThread = null;
	private Notifier fSyncer = null;
	private UUID fLastSync = null;

	private final CopyOnWriteArrayList<IConfigurationChangeListener> fListeners;


	/**
	 * Constructor
	 * @param session
	 * @param keyspace
	 * @param tableName
	 */
	public RemoteConfigurationStore()
	{
		fListeners = new CopyOnWriteArrayList<>();
	}


	@Activate
	public void activate()
	{
		fSession = fCluster.getCluster().connect();

		fConfigurationChangeEventTable = new ConfigurationChangeEventTable(this, "configuration", "configuration");
		fConfigurationChangeEventTable.createTable();

		fLastSync = fConfigurationChangeEventTable.currentTimeStamp();
		fSyncer = new Notifier();
		fSyncThread = new Thread(fSyncer, "configuration sync thread");
		fSyncThread.start();
	}


	@Deactivate
	public void deactivate()
	{
		fSyncer.stop();
		try
		{
			fSyncThread.interrupt();
			fSyncThread.join(500L);
		}
		catch (InterruptedException e)
		{
			Thread.interrupted();
		}

		fConfigurationChangeEventTable = null;
		fSession.close();
		fSession = null;
	}


	@Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC, target = "(cluster.name=DISABLED)")
	public void setNamedCluster(final NamedCluster c)
	{
		fCluster = c;
	}


	public ResultSet query(final String s)
	{
		return fSession.execute(s);
	}


	public ResultSet query(final Statement s)
	{
		return fSession.execute(s);
	}


	public void query(final Statement s, final StreamObserver<?> o, final IResultSetHandler h)
	{
		assert o != null;
		try
		{
			h.run(fSession.execute(s));
		}
		catch (final Throwable t)
		{
			t.printStackTrace();
			System.err.println(t.getMessage());
			o.onError(new StatusException(Status.fromThrowable(t)));
		}
	}


	@Override
	public void addConfigurationChangeListener(IConfigurationChangeListener l)
	{
		fListeners.add(l);
	}


	@Override
	public void removeConfigurationChangeListener(IConfigurationChangeListener l)
	{
		fListeners.remove(l);
	}


	@Override
	public void getGlobalConfigOption(Path request, StreamObserver<ValueOption> responseObserver)
	{
		// TODO Auto-generated method stub

	}


	@Override
	public void getLeveledConfigOption(Option request, StreamObserver<ValueOption> responseObserver)
	{
		// TODO Auto-generated method stub

	}


	@Override
	public StreamObserver<Option> getLeveledConfigOptions(StreamObserver<ValueOption> responseObserver)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StreamObserver<Path> getGlobalConfigOptions(StreamObserver<ValueOption> responseObserver)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setConfigOption(ValueOption request, StreamObserver<Empty> responseObserver)
	{
		fConfigurationChangeEventTable.insert(Integer.toString(request.getLevel()), request.getPath(), request.getType(), request.getData().asReadOnlyByteBuffer(), responseObserver, new IResultSetHandler()
		{
			@Override
			public void run(ResultSet s)
			{
				responseObserver.onCompleted();
			}
		});
		onSet(request);
	}


	@Override
	public void unsetLeveledConfigOption(Option request, StreamObserver<Empty> responseObserver)
	{
		fConfigurationChangeEventTable.insert(Integer.toString(request.getLevel()), request.getPath(), null, null, responseObserver, new IResultSetHandler()
		{
			@Override
			public void run(ResultSet s)
			{
				responseObserver.onCompleted();
			}
		});

		onRemove(request);
	}


	@Override
	public void unsetGlobalConfigOption(Path request, StreamObserver<Empty> responseObserver)
	{
		fConfigurationChangeEventTable.insert(null, request.getPath(), null, null, responseObserver, new IResultSetHandler()
		{
			@Override
			public void run(ResultSet s)
			{
				responseObserver.onCompleted();
			}
		});

		onRemoveAll(request);
	}


	@Override
	public void getLeveledNameList(Option request, StreamObserver<NameList> responseObserver)
	{
		// TODO Auto-generated method stub

	}


	@Override
	public void getGlobalNameList(Path request, StreamObserver<NameList> responseObserver)
	{
		// TODO Auto-generated method stub

	}


	@Override
	public void getLevel(Level request, StreamObserver<ValueOption> responseObserver)
	{
		// TODO Auto-generated method stub

	}


	// Forward change events to listeners

	@Override
	public void onRemoveAll(final Path v)
	{
		fListeners.parallelStream().forEach(c -> c.onRemoveAll(v));
	}


	@Override
	public void onRemove(final Option v)
	{
		fListeners.parallelStream().forEach(c -> c.onRemove(v));
	}


	@Override
	public void onSet(ValueOption v)
	{
		fListeners.parallelStream().forEach(c -> c.onSet(v));
	}

	private class Notifier implements Runnable, StreamObserver<Object>
	{
		private boolean fRun = true;


		private void notifyListeners()
		{
			fConfigurationChangeEventTable.select(fLastSync, this, new IResultSetHandler()
			{
				@Override
				public void run(final ResultSet s)
				{
					s.forEach(r -> {
//						// see what the action is
//						if (set)
//						{
//							ValueOption v;
//							onSet(v);
//						}
//						else if (removeLevel)
//						{
//							Option o;
//							onRemove(o);
//						}
//						else if (removeAll)
//						{
//							Path p;
//							onRemoveAll(p);
//						}
					});
				}
			});
		}

		public void run()
		{
			while (fRun)
			{
				try
				{
					notifyListeners();
					Thread.sleep(50L);
				}
				catch (InterruptedException e)
				{
					return;
				}
			}
		}


		public void stop()
		{
			fRun = false;
		}


		@Override
		public void onCompleted()
		{
		}


		@Override
		public void onError(Throwable t)
		{
			// TODO
		}


		@Override
		public void onNext(Object arg0)
		{
		}
	}
}
