package com.example.demo.loggers;

public final class LoggerLevelChecker {
	private static final String STRING_LOG_LEVELS       = "-----LOG LEVELS-----";
	private static final String STRING_IS_TRACE_ENABLED = "Trace  Enabled: ";
	private static final String STRING_IS_DEBUG_ENABLED = "Debug  Enabled: ";
	private static final String STRING_IS_INFO_ENABLED  = "Info   Enabled: ";
	private static final String STRING_IS_WARN_ENABLED  = "Warn   Enabled: ";
	private static final String STRING_IS_ERROR_ENABLED = "Error  Enabled: ";
	private static final String STRING_IS_FATAL_ENABLED = "Fatal  Enabled: ";
	private static final String STRING_LOG_END          = "--------------------";

	// we should this only in debug, if not enabled, we may don't care about this;
	// or continue later
	@SuppressWarnings("unused")
	private static void LogLevelSearcher(org.slf4j.Logger logger) {
		if (!logger.isTraceEnabled() && !logger.isDebugEnabled() && !logger.isInfoEnabled() && !logger.isWarnEnabled()
				&& !logger.isErrorEnabled()) {
			return;
		} else {
		}
	}

	public static void LogLoggerLevels(org.slf4j.Logger logger) {
		if (logger.isDebugEnabled()) {
			logger.debug(STRING_LOG_LEVELS);
			logger.debug(logger.getName());
			logger.debug(STRING_IS_TRACE_ENABLED + logger.isTraceEnabled());
			logger.debug(STRING_IS_DEBUG_ENABLED + logger.isDebugEnabled());
			logger.debug(STRING_IS_INFO_ENABLED + logger.isInfoEnabled());
			logger.debug(STRING_IS_WARN_ENABLED + logger.isWarnEnabled());
			logger.debug(STRING_IS_ERROR_ENABLED + logger.isErrorEnabled());
			logger.debug(STRING_LOG_END);
		}
	}

	public static void LogLoggerLevels(org.apache.logging.log4j.Logger logger) {
		if (logger.isDebugEnabled()) {
			logger.debug(STRING_LOG_LEVELS);
			logger.debug(logger.getName());
			logger.debug(STRING_IS_TRACE_ENABLED + logger.isTraceEnabled());
			logger.debug(STRING_IS_DEBUG_ENABLED + logger.isDebugEnabled());
			logger.debug(STRING_IS_INFO_ENABLED + logger.isInfoEnabled());
			logger.debug(STRING_IS_WARN_ENABLED + logger.isWarnEnabled());
			logger.debug(STRING_IS_ERROR_ENABLED + logger.isErrorEnabled());
			logger.debug(STRING_IS_FATAL_ENABLED + logger.isFatalEnabled());
			logger.debug(STRING_LOG_END);
		}
	}

}
