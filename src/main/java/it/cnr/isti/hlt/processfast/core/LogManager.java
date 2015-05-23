package it.cnr.isti.hlt.processfast.core;

/**
 * A generic log manager.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface LogManager {
	
	/**
	 * Get the logger with the specified name. If the logger requested
	 * does not exist, it will be created.
	 * 
	 * @param loggerName The logger name.
	 */
	public Logger getLogger(String loggerName);
	
	/**
	 * Remove the log data associated with this logger.
	 * 
	 * @param loggerName The logger to remove.
	 */
	public void removeLogger(String loggerName);
}
