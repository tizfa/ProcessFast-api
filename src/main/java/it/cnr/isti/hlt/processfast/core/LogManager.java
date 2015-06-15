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
	Logger getLogger(String loggerName);
	
	/**
	 * Remove the log data associated with this logger.
	 * 
	 * @param loggerName The logger to remove.
	 */
	void removeLogger(String loggerName);
}
