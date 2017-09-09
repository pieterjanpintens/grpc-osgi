package com.id.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	public static final Path kAPPLICATION_HOME = getApplicationHome();

	private static Path getApplicationHome() {
		final String applicationHomeStr = System.getProperty(kAPPLICATION_HOME_PROPERTY);
		if (applicationHomeStr == null) {
			printErrorAndDie(true, null, null);
		}
		Path applicationHome = Paths.get(applicationHomeStr);
		try {
			Files.write(applicationHome.resolve(".dustfile"), "ASHES TURNED TO DUST".getBytes());
		} catch (IOException e) {
			printErrorAndDie(false, applicationHomeStr, e);
		}
		return applicationHome;
	}

	private static void printErrorAndDie(final boolean missing, final String path, final Throwable t) {
		if (missing) {
			System.err.println("Missing system property '" + kAPPLICATION_HOME_PROPERTY + "'");
		} else {
			System.err.println("The application path '" + path + "' specified by system property '"
					+ kAPPLICATION_HOME_PROPERTY + "' could not be used");
		}
		System.err.println("Set this to a location on disk where the application can write to");
		if (t != null) {
			t.printStackTrace(System.err);
		}
		System.exit(kEXIT_NO_APPLICATION_HOME);
	}
}
