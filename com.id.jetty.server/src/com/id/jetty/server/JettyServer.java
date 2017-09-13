package com.id.jetty.server;

import java.nio.file.Path;
import java.util.Hashtable;

import org.eclipse.jetty.server.Server;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.id.application.Constants;

@Component
public class JettyServer {

	private final Logger fLog = LoggerFactory.getLogger(getClass());

	private Server fServer;

	private ServiceRegistration<Server> fServerService;

	private short fPort = 8081;

	@Activate
	void activate(final BundleContext ctx) {
		final Path etc = Constants.kAPPLICATION_HOME.resolve("etc/jetty");
		
		
		fLog.info("Starting Jetty server on port {}", fPort);
		try {
			fServer = new Server();
			String serverName = "fooServer";
			Hashtable<String, String> serverProps = new Hashtable<>();
			serverProps.put("managedServerName", serverName);
			serverProps.put("jetty.http.port", Short.toString(fPort));
			serverProps.put("jetty.etc.config.urls",
					etc.resolve("jetty.xml").toUri().toString() + ","
					+ etc.resolve("jetty-selector.xml").toUri().toString() + ","
					+ etc.resolve("jetty-deployer.xml").toUri().toString());
			ctx.registerService(Server.class.getName(), fServer, serverProps);
			fLog.info("Started Jetty server on port {}", fPort);
		} catch (Throwable t) {
			fLog.error("Failed to start Jetty server on port {}", fPort, t);
		}
	}

	@Deactivate
	void deactivate() {
		fLog.info("Stopping Jetty server on port {}", fPort);
		fServerService.unregister();
		fServerService = null;
		try {
			fServer.destroy();
			//TODO
			fServer.join();
			
			//Timeout?
			//if (false) {
			//	fLog.error("Failed to stop Jetty server on port {} within 1 second", fPort);
			//}
			
		} catch (final InterruptedException e) {
			fLog.error("Stop of Jetty server on port {} was interrupted", fPort);
			Thread.interrupted();
		}
		fServer = null;
	}
}
