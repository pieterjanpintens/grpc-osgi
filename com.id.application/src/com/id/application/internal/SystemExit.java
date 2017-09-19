package com.id.application.internal;

/**
 * Abstraction around system exit call.
 * 
 * @author pjpinten
 *
 */
public class SystemExit {

	/**
	 * Print error to system err and exit with given code.
	 * @param code
	 * @param msg
	 * @param t
	 * @return the code
	 */
	public int printErrorAndDie(final int code, String msg, final Throwable t) {
		System.err.println(msg);
		if (t != null) {
			t.printStackTrace(System.err);
		}
		System.exit(code);
		return code;
	}
}
