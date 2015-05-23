package it.cnr.isti.hlt.processfast.core;

/**
 * Define the predefined level of logging in
 * a specific logger. The levels are prioritized:<BR/>
 * DEBUG &lt; INFO &lt; WARNING &lt; ERROR. <BR/><BR/>
 * After you have set a specific level, every log message
 * with a level less than the level you set is not logged,
 * every message with level greater than the level you set
 * is logged.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public enum LogLevel {

	DEBUG(1),
	INFO(2),
	WARNING(3),
	ERROR(4);

	private int levelValue;

	LogLevel(int levelValue) {
		this.levelValue = levelValue;
	}

	/**
	 * Get the level value for this specific log level.
	 *
	 * @return The level value for this specific log level.
	 */
	public int getLevelValue() {
		return levelValue;
	}
}
