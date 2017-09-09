
package com.id.grpc.server;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.BindableService;
import io.grpc.HandlerRegistry;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerProvider;

/**
 * Server for {@link BindableService}. This server will host these services on port 8080.
 * It will dynamically pick up {@link BindableService} when they are registered.
 * 
 * @author pjpinten
 */
@Component
public class ServerApplication
{
	private final OSGiHandlerRegistry fServiceRegistry = new OSGiHandlerRegistry();
	private Server fServer = null;
	
	private final Logger fLog = LoggerFactory.getLogger(getClass());
	
	@Reference
	private ServerProvider fServerProvider;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	public void addBindableService(final BindableService bindService)
	{
		fServiceRegistry.add(bindService);
		fLog.debug("Added {} to GRCP server running on port 8080", bindService.getClass().getName());
	}


	public void removeBindableService(final BindableService bindService)
	{
		fServiceRegistry.remove(bindService);
		fLog.debug("Removed {} to GRCP server running on port 8080", bindService.getClass().getName());
	}


	@Activate
	void activate()
	{
		fLog.info("Starting GRCP server on port 8080");
		try
		{
			fServer = ServerBuilder.forPort(8080).fallbackHandlerRegistry(fServiceRegistry).build();
			fServer.start();
			fLog.info("Started GRCP server on port 8080");
		}
		catch (Throwable t) {
			fLog.error("Failed to start GRCP server on port 8080", t);
		}
	}


	@Deactivate
	void deactivate()
	{
		try
		{
			if (!fServer.shutdown().awaitTermination(1, TimeUnit.SECONDS))
			{
				fLog.error("Failed to stop server within 1 second");
			}
		}
		catch (final InterruptedException e)
		{
			fLog.error("Stop of server was interrupted");
			Thread.interrupted();
		}
		fServer = null;
	}

	/**
	 * Dynamic OSGi based {@link HandlerRegistry}
	 * 
	 * @author pjpinten
	 */
	private static class OSGiHandlerRegistry extends HandlerRegistry
	{
		private final Set<BindableService> fServices = new HashSet<>();


		@Override
		public ServerMethodDefinition<?, ?> lookupMethod(final String methodName, final String authority)
		{
			synchronized (fServices)
			{
				for (final BindableService s : fServices)
				{
					final ServerMethodDefinition<?, ?> result = s.bindService().getMethod(methodName);
					if (result != null)
					{
						return result;
					}
				}
			}
			return null;
		}


		public void add(final BindableService bindService)
		{
			synchronized (fServices)
			{
				fServices.add(bindService);
			}
		}


		public void remove(final BindableService bindService)
		{
			synchronized (fServices)
			{
				fServices.remove(bindService);
			}
		}

	}
}
