/*
 * *****************
 *  Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
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
 * *******************
 */

package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.Dictionary;
import it.cnr.isti.hlt.processfast.data.StorageManager;

import java.util.List;

/**
 * The main interface for manage a running tasks set.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface RunningTasksSet {

	/**
	 * Get the log manager provided by the system.
	 * 
	 * @return The log manager provided by the system.
	 */
	LogManager getLogManager();
	
	
	/**
	 * Get the storage manager available in the running system.
	 *
	 * @return The storage manager available in the running system.
	 */
	StorageManager getStorageManager();
	
	
	/**
	 * Used to pass or return values to/from runtime from/to the caller of program.
	 *
	 * @return A generic data dictionary.
	 */
	Dictionary getDataDictionary();
	
	
	/**
	 * Stop the current running executable tasks set (by killing all tasks belonging to the executable tasks set) and relaunch
	 * the tasks set from scratch.
	 */
	void restartTasksSet();
	
	/**
	 * Kill all the tasks specified in the given list of names. Note that during
	 * program configuration you can assign a name of a task by using {@link TaskDescriptor#withName}
	 * method.
	 * 
	 * @param taskNames The set of tasks to be relaunched.
	 */
	void killTasks(List<String> taskNames);
	
	/**
	 * Relaunch the tasks specified in the given list of names. Note that during
	 * program configuration you can assign a name of a task by using {@link TaskDescriptor#withName}
	 * method.
	 * 
	 * @param taskNames The set of tasks to be relaunched.
	 */
	void relaunchTasks(List<String> taskNames);
	
	/**
	 * Stop the running tasks set by killing all its running tasks.
	 */
	void stopTasksSet();
}
