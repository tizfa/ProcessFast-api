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

import it.cnr.isti.hlt.processfast.connector.ValuePromise;
import it.cnr.isti.hlt.processfast.data.ReadableDictionary;
import it.cnr.isti.hlt.processfast.data.StorageManager;

/**
 * A context used to access Processfast runtime global resources.  
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface SystemContext {
	/**
	 * Get the log manager provided by the system. The log manager is shared among
	 * all tasks and tasks sets defined in a specific program.
	 * 
	 * @return The log manager provided by the system.
	 */
	LogManager getLogManager();
	
	
	/**
	 * Get the storage manager available on the system. The storage manager and
	 * all its contained data structures are shared among
	 * all tasks and tasks sets defined in a specific program.
	 * 
	 * @return The storage manager available on the system.
	 */
	StorageManager getStorageManager();


	/**
	 * Exec atomically the specified set of operations on the running application and in the specified critical section. The
	 * execution of the operations is done asynchronously respect to
	 * the method call.
	 *
	 * @param criticalSectionName The name of critical section.
	 * @param inputData           The input data dictionary.
	 * @param operations          The set of operations to be executed.
	 */
	ValuePromise<Void> atomic(String criticalSectionName, ReadableDictionary inputData, AtomicOperationsSet operations);


	/**
	 * Exec atomically the specified set of operations on the running application and in the specified critical section. The
	 * execution of the operations is done asynchronously respect to
	 * the method call.
	 *
	 * @param criticalSectionName The name of critical section.
	 * @param operations          The set of operations to be executed.
	 */
	ValuePromise<Void> atomic(String criticalSectionName, AtomicOperationsSet operations);


	/**
	 * Exec atomically the specified set of operations on the running application and in the specified critical section. The execution of
	 * the operations is done synchronously and can return output data to the caller in the
	 * form of a data dictionary.
	 *
	 * @param criticalSectionName The name of critical section.
	 * @param inputData           The input data dictionary.
	 * @param operations          The set of operations to be executed.
	 * @return The output data from the set of operations executed.
	 */
	ValuePromise<ReadableDictionary> atomicGet(String criticalSectionName, ReadableDictionary inputData, AtomicGetOperationsSet operations);


	/**
	 * Exec atomically the specified set of operations on the running application and in the specified critical section.
	 * The execution of the operations is done synchronously and can return output data to the caller in the
	 * form of a data dictionary. To maximize throughput, each set of operations will be
	 * executed optimistically. In case of data conflicts, the system will abort
	 * the considered set of operations and will retry to perform it until successful completion.
	 *
	 * @param criticalSectionName The name of critical section.
	 * @param operations          The set of operations to be executed.
	 * @return The output data from the set of operations executed.
	 */
	ValuePromise<ReadableDictionary> atomicGet(String criticalSectionName, AtomicGetOperationsSet operations);
		
}
