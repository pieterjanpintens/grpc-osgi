package com.id.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.id.application.internal.SystemExit;

/**
 * Application constants.
 * 
 * @author Pieter-Jan
 *
 */
public class Constants {

	public static final int kEXIT_NO_APPLICATION_HOME = -1;

	public static final String kAPPLICATION_HOME_PROPERTY = "application.home";

	/**
	 * Application Home folder, this should be a folder in which the application can
	 * write. It will contain local configuration files, work folders etc. If it can
	 * not be set the application will exit.
	 */
	public static final Path kAPPLICATION_HOME = getApplicationHome(new SystemExit());

	static Path getApplicationHome(final SystemExit exiter) {
		final String applicationHomeStr = System.getProperty(kAPPLICATION_HOME_PROPERTY);
		if (applicationHomeStr == null) {
			printErrorAndDie(exiter, true, null, null);
		}
		Path applicationHome = Paths.get(applicationHomeStr);
		try {
			Files.write(applicationHome.resolve(".dustfile"), "ASHES TURNED TO DUST".getBytes());
		} catch (IOException e) {
			printErrorAndDie(exiter, false, applicationHomeStr, e);
		}
		return applicationHome;
	}

	private static void printErrorAndDie(final SystemExit exiter, final boolean missing, final String path, final Throwable t) {
		StringBuilder sb = new StringBuilder();
		if (missing) {
			sb.append("Missing system property '" + kAPPLICATION_HOME_PROPERTY + "'.\n");
		} else {
			sb.append("The application path '" + path + "' specified by system property '" + kAPPLICATION_HOME_PROPERTY + "' could not be used.\n");
		}
		sb.append("Set this to a location on disk where the application can write to.");
		exiter.printErrorAndDie(kEXIT_NO_APPLICATION_HOME, sb.toString(), t);
	}
}
