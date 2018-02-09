package com.example.demo.loggers;

public class ConsoleLogger extends ALogger {

	public ConsoleLogger(String loggerName, boolean isTraceEnabled, boolean isDebugEnabled,
			boolean isInfoEnabled, boolean isWarnEnabled, boolean isErrorEnabled) {
		super(loggerName, isTraceEnabled, isDebugEnabled, isInfoEnabled, isWarnEnabled, isErrorEnabled);
	}
	
	private final static String MESSAGE_PATTERN = "[%s] %s: %s";
	
	@Override
	protected void LogTrace(String msg) {
		System.out.println(String.format(MESSAGE_PATTERN, getName(), TRACE_STRING, msg));
	}

	@Override
	protected void LogInfo(String msg) {
		System.out.println(String.format(MESSAGE_PATTERN, getName(), INFO_STRING, msg));
	}

	@Override
	protected void LogDebug(String msg) {
		System.out.println(String.format(MESSAGE_PATTERN, getName(), DEBUG_STRING, msg));		
	}

	@Override
	protected void LogWarn(String msg) {
		System.out.println(String.format(MESSAGE_PATTERN, getName(), WARN_STRING, msg));		
	}

	@Override
	protected void LogError(String msg) {
		System.out.println(String.format(MESSAGE_PATTERN, getName(), ERROR_STRING, msg));		
	}

}
