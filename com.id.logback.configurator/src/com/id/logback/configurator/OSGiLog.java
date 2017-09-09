package com.id.logback.configurator;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bridge between OSGI log service and SLF4j.
 * 
 * @author Pieter-Jan
 *
 */
@Component(immediate = true)
public class OSGiLog implements LogListener {

	@Reference
	private LogReaderService fReader;

	private final Logger fLog = LoggerFactory.getLogger(getClass());

	@Activate
	void activate() {
		fReader.addLogListener(this);
	}

	@Deactivate
	void deactivate() {
		fReader.removeLogListener(this);
	}

	@Override
	public void logged(final LogEntry entry) {
		if (entry.getLevel() == LogService.LOG_DEBUG) {
			if (fLog.isDebugEnabled()) {
				fLog.debug(entry.getMessage(), entry.getException());
			}
		} else if (entry.getLevel() == LogService.LOG_WARNING) {
			if (fLog.isWarnEnabled()) {
				fLog.warn(entry.getMessage(), entry.getException());
			}
		} else if (entry.getLevel() == LogService.LOG_INFO) {
			if (fLog.isInfoEnabled()) {
				fLog.info(entry.getMessage(), entry.getException());
			}
		} else if (entry.getLevel() == LogService.LOG_ERROR) {
			if (fLog.isErrorEnabled()) {
				fLog.error(entry.getMessage(), entry.getException());
			}
		}
	}
}
