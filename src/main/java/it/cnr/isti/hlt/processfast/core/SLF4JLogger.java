package it.cnr.isti.hlt.processfast.core;

/**
 * A thread-safe logger implementation based on SLF4J.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class SLF4JLogger implements Logger {
    private final org.slf4j.Logger loggerUsed;

    private LogLevel level = LogLevel.INFO;

    SLF4JLogger(org.slf4j.Logger loggerUsed) {
        if (loggerUsed == null)
            throw new NullPointerException("The specified logger is 'null");
        this.loggerUsed = loggerUsed;
    }

    @Override
    public synchronized void info(String msg) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.INFO.getLevelValue()) {
            if (loggerUsed.isInfoEnabled())
                loggerUsed.info(msg);
        }
    }

    @Override
    public synchronized void info(String msg, Throwable t) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");
        if (t == null)
            throw new NullPointerException("The specified throwable is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.INFO.getLevelValue()) {
            if (loggerUsed.isInfoEnabled())
                loggerUsed.info(msg, t);
        }
    }

    @Override
    public synchronized void warning(String msg) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.WARNING.getLevelValue()) {
            if (loggerUsed.isWarnEnabled())
                loggerUsed.warn(msg);
        }
    }

    @Override
    public synchronized void warning(String msg, Throwable t) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");
        if (t == null)
            throw new NullPointerException("The specified throwable is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.WARNING.getLevelValue()) {
            if (loggerUsed.isWarnEnabled())
                loggerUsed.warn(msg, t);
        }
    }

    @Override
    public synchronized void error(String msg) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");


        if (getLogLevel().getLevelValue() <= LogLevel.ERROR.getLevelValue()) {
            if (loggerUsed.isErrorEnabled())
                loggerUsed.error(msg);
        }
    }

    @Override
    public synchronized void error(String msg, Throwable t) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");
        if (t == null)
            throw new NullPointerException("The specified throwable is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.ERROR.getLevelValue()) {
            if (loggerUsed.isErrorEnabled())
                loggerUsed.error(msg, t);
        }
    }

    @Override
    public synchronized void debug(String msg) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.DEBUG.getLevelValue()) {
            if (loggerUsed.isDebugEnabled())
                loggerUsed.debug(msg);
        }
    }

    @Override
    public synchronized void debug(String msg, Throwable t) {
        if (msg == null)
            throw new NullPointerException("The msg is 'null'");
        if (t == null)
            throw new NullPointerException("The specified throwable is 'null'");

        if (getLogLevel().getLevelValue() <= LogLevel.DEBUG.getLevelValue()) {
            if (loggerUsed.isDebugEnabled())
                loggerUsed.debug(msg, t);
        }
    }

    @Override
    public synchronized void setLogLevel(LogLevel level) {
        if (level == null)
            throw new NullPointerException("The specified level is 'null'");

        this.level = level;
    }

    @Override
    public synchronized LogLevel getLogLevel() {
        return level;
    }
}
