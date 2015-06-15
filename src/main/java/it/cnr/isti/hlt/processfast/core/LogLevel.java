/*
 *
 * ****************
 * Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ******************
 */

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
