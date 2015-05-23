package it.cnr.isti.hlt.processfast.core;


/**
 * A generic logger interface.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface Logger {
    /**
     * Log the specified INFO message.
     *
     * @param msg The message to be logged.
     */
    void info(String msg);


    /**
     * Log the specified INFO message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void info(String msg, Throwable t);

    /**
     * Log the specified WARNING message.
     *
     * @param msg The message to be logged.
     */
    void warning(String msg);

    /**
     * Log the specified WARNING message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void warning(String msg, Throwable t);


    /**
     * Log the specified ERROR message.
     *
     * @param msg The message to be logged.
     */
    void error(String msg);


    /**
     * Log the specified ERROR message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void error(String msg, Throwable t);


    /**
     * Log the specified DEBUG message.
     *
     * @param msg The message to be logged.
     */
    void debug(String msg);


    /**
     * Log the specified DEBUG message, attaching the given throwable.
     *
     * @param msg The message to be logged.
     * @param t   The throwable to attach.
     */
    void debug(String msg, Throwable t);


    /**
     * Set the log level of the logger (see {@link LogLevel}
     * for more details about levels).
     *
     * @param level The level to be set.
     */
    void setLogLevel(LogLevel level);


    /**
     * Get the current log level.
     *
     * @return The current log level.
     */
    LogLevel getLogLevel();
}
