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

package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.connector.ValuePromise;

import java.util.List;

/**
 * A generic storages manager.
 * 
 * Each operation performed on managed storages and their data structures is atomic by default, so 
 * the programmer is responsible to guarantee a proper access
 * to the data structures in order to maintain the logical consistency of the
 * data. If a programmer need to perform a logical set of operations atomically on several
 * data structures, he can
 * use {@link #atomic(ReadableDictionary, AtomicOperationsSet)} or
 * {@link #atomicGet(ReadableDictionary, AtomicGetOperationsSet)} methods to execute
 * the wanted operations.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface StorageManager {
	/**
	 * Get the set of storages declared on this manager.
	 * 
	 * @return The set of storages available on this manager.
	 */
	List<String> getStorageNames();
	
	/**
	 * Check if the specified storage is declared on this manager.
	 * 
	 * @param name The name of the storage to check.
	 * @return True if the requested storage exists, false otherwise.
	 */
	boolean containsStorageName(String name);
	
	/**
	 * Create a new storage. If a storage with this name already exists, the
	 * method will return it.
	 * 
	 * @param name The name of the new storage.
	 * @return The corresponding storage.
	 */
	Storage createStorage(String name);
	
	/**
	 * Remove a specific storage.
	 * 
	 * @param name The name of the storage to remove.
	 */
	void removeStorage(String name);
	
	/**
	 * Get a specific storage.
	 * 
	 * @param name The name of the storage to retrieve.
	 * @return The requested storage or 'null' if the storage can not be found.
	 */
	Storage getStorage(String name);
		
	
	/**
	 * Flush the data of all contained data structures, eventually stored locally in memory, to 
	 * the destination storage.
	 */
	void flushData();



    /**
     * Delete all data stored on this storage container.
     */
    void clear();
}
