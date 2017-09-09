package com.id.logback.configurator;

import java.nio.file.Path;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.LoggerFactory;

import com.id.application.Constants;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

@Component
public class LogbackConfigurator {

	@Activate
	public void activate() {
		reconfigure();
	}

	public void reconfigure() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator jc = new JoranConfigurator();
		jc.setContext(context);
		context.reset();

		// overriding the log directory property programmatically
		// context.putProperty("LOG_DIR",
		// "C:\\Users\\Pieter-Jan\\eclipse-workspace-ring\\config\\log");

		final Path logbackFile = Constants.kAPPLICATION_HOME.resolve("log/logback.xml");

		try {
			jc.doConfigure(logbackFile.toFile());
		} catch (final JoranException e) {
			System.err.println("Failed to configure logback using " + logbackFile.toString());
			System.err.println("Logging will be limited, it is recommended to fix this before going further");
			e.printStackTrace(System.err);
		}
	}
}
