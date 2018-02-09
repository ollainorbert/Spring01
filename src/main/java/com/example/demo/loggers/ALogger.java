package com.example.demo.loggers;

import org.slf4j.Logger;
import org.slf4j.Marker;

public abstract class ALogger implements Logger {

	public ALogger(String loggerName, boolean isTraceEnabled, boolean isDebugEnabled,
			boolean isInfoEnabled, boolean isWarnEnabled, boolean isErrorEnabled) {
		this.loggerName = loggerName;
		this.isTraceOn = isTraceEnabled;
		this.isDebugOn = isDebugEnabled;
		this.isInfoOn = isInfoEnabled;
		this.isWarnOn = isWarnEnabled;
		this.isErrorOn = isErrorEnabled;
	}

	private String loggerName;
	private boolean isTraceOn;
	private boolean isDebugOn;
	private boolean isInfoOn;
	private boolean isWarnOn;
	private boolean isErrorOn;

	protected final static String TRACE_STRING = "Trace";
	protected final static String INFO_STRING = "Information";
	protected final static String DEBUG_STRING = "Debug";
	protected final static String WARN_STRING = "Warning";
	protected final static String ERROR_STRING = "Error";

	protected abstract void LogTrace(String msg);

	protected abstract void LogInfo(String msg);

	protected abstract void LogDebug(String msg);

	protected abstract void LogWarn(String msg);

	protected abstract void LogError(String msg);

	@Override
	public String getName() {
		return this.loggerName;
	}

	@Override
	public boolean isTraceEnabled() {
		return this.isTraceOn;
	}

	@Override
	public void trace(String msg) {
		if (this.isTraceOn) {
			this.LogTrace(msg);
		}
	}

	@Override
	public void trace(String format, Object arg) {
		if (this.isTraceOn) {
			this.LogTrace(String.format(format, arg));
		}
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		if (this.isTraceOn) {
			this.LogTrace(String.format(format, arg1, arg2));
		}
	}

	@Override
	public void trace(String format, Object... arguments) {
		if (this.isTraceOn) {
			this.LogTrace(String.format(format, arguments));
		}
	}

	@Override
	public void trace(String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void trace(Marker marker, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDebugEnabled() {
		return this.isDebugOn;
	}

	@Override
	public void debug(String msg) {
		if(this.isDebugOn) {
			this.LogDebug(msg);
		}
	}

	@Override
	public void debug(String format, Object arg) {
		if(this.isDebugOn) {
			this.LogDebug(String.format(format, arg));
		}
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		if(this.isDebugOn) {
			this.LogDebug(String.format(format, arg1, arg2));
		}
	}

	@Override
	public void debug(String format, Object... arguments) {
		if(this.isDebugOn) {
			this.LogDebug(String.format(format, arguments));
		}
	}

	@Override
	public void debug(String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void debug(Marker marker, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void info(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void info(Marker marker, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void warn(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void warn(Marker marker, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void error(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void error(Marker marker, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub

	}

}
