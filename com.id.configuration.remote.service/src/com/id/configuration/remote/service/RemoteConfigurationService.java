/*
 * Copyright 2016 Inventive Designers nv.
 */

package com.id.configuration.remote.service;

import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.id.configuration.proto.ChangeEvent;
import com.id.configuration.proto.ConfigurationServiceGrpc.ConfigurationServiceImplBase;
import com.id.configuration.remote.store.IConfigurationChangeListener;
import com.id.configuration.remote.store.IConfigurationStore;
import com.id.configuration.proto.Empty;
import com.id.configuration.proto.Level;
import com.id.configuration.proto.NameList;
import com.id.configuration.proto.Operation;
import com.id.configuration.proto.Option;
import com.id.configuration.proto.Path;
import com.id.configuration.proto.ValueOption;

import io.grpc.stub.StreamObserver;

/**
 * Service for remote configuration.
 * 
 * @author pjpinten
 */
@Component(service = io.grpc.BindableService.class, immediate=true)
public class RemoteConfigurationService extends ConfigurationServiceImplBase implements IConfigurationChangeListener
{
	private final CopyOnWriteArrayList<StreamObserver<ChangeEvent>> fListeners;

	private IConfigurationStore fStore;

	private Logger fLog = LoggerFactory.getLogger(getClass());
	
	/**
	 * Constructor
	 * @param session
	 * @param keyspace
	 * @param tableName
	 */
	public RemoteConfigurationService()
	{
		fListeners = new CopyOnWriteArrayList<>();
	}


	@Override
	public void getGlobalConfigOption(Path request, StreamObserver<ValueOption> responseObserver)
	{
		fLog.debug("getGlobalConfigOption {}", request);
		fStore.getGlobalConfigOption(request, responseObserver);
	}


	@Override
	public void getLeveledConfigOption(Option request, StreamObserver<ValueOption> responseObserver)
	{
		fLog.debug("getLeveledConfigOption {}", request);
		fStore.getLeveledConfigOption(request, responseObserver);
	}


	@Override
	public StreamObserver<Option> getLeveledConfigOptions(StreamObserver<ValueOption> responseObserver)
	{
		return fStore.getLeveledConfigOptions(responseObserver);
	}


	@Override
	public StreamObserver<Path> getGlobalConfigOptions(StreamObserver<ValueOption> responseObserver)
	{
		return fStore.getGlobalConfigOptions(responseObserver);
	}


	@Override
	public void setConfigOption(ValueOption request, StreamObserver<Empty> responseObserver)
	{
		fLog.debug("setConfigOption {}", request);
		fStore.setConfigOption(request, responseObserver);
	}


	@Override
	public void unsetLeveledConfigOption(Option request, StreamObserver<Empty> responseObserver)
	{
		fLog.debug("unsetLeveledConfigOption {}", request);
		fStore.unsetLeveledConfigOption(request, responseObserver);
	}


	@Override
	public void unsetGlobalConfigOption(Path request, StreamObserver<Empty> responseObserver)
	{
		fStore.unsetGlobalConfigOption(request, responseObserver);
	}


	@Override
	public void getLeveledNameList(Option request, StreamObserver<NameList> responseObserver)
	{
		fStore.getLeveledNameList(request, responseObserver);
	}


	@Override
	public void getGlobalNameList(Path request, StreamObserver<NameList> responseObserver)
	{
		fStore.getGlobalNameList(request, responseObserver);
	}


	@Override
	public void getLevel(Level request, StreamObserver<ValueOption> responseObserver)
	{
		fStore.getLevel(request, responseObserver);
	}


	@Override
	public final StreamObserver<Empty> listen(final StreamObserver<ChangeEvent> responseObserver)
	{
		fListeners.add(responseObserver);

		return new StreamObserver<Empty>()
		{

			@Override
			public void onCompleted()
			{
				fListeners.remove(responseObserver);
			}


			@Override
			public void onError(final Throwable e)
			{
				// TODO LOG
				fListeners.remove(responseObserver);
			}


			@Override
			public void onNext(final Empty e)
			{
				// ignore
			}
		};
	}


	@Override
	public void onRemoveAll(final Path v)
	{
		fListeners.stream().forEach(s -> s.onNext(ChangeEvent.newBuilder().setOption(ValueOption.newBuilder().setPath(v.getPath()).build()).setOperation(Operation.SET).build()));
	}


	@Override
	public void onRemove(final Option v)
	{
		fListeners.stream().forEach(s -> s.onNext(ChangeEvent.newBuilder().setOption(ValueOption.newBuilder().setPath(v.getPath()).setLevel(v.getLevel()).build()).setOperation(Operation.SET).build()));
	}


	@Override
	public void onSet(final ValueOption v)
	{
		fListeners.stream().forEach(s -> s.onNext(ChangeEvent.newBuilder().setOption(v).setOperation(Operation.SET).build()));
	}


	@Activate
	public void activate()
	{
		fStore.addConfigurationChangeListener(this);
	}


	@Deactivate
	public void deactivate()
	{
		fStore.removeConfigurationChangeListener(this);
	}


	@Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
	public void setStore(final IConfigurationStore c)
	{
		fStore = c;
	}

}
