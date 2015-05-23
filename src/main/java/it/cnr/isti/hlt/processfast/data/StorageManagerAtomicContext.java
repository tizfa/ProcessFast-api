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

/**
 * The runtime context in a storage manager transaction.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 */
public interface StorageManagerAtomicContext {
	/**
	 * Get the storage manager to use inside this transaction.
	 *  
	 * @return The storage manager to use.
	 */
	public StorageManager getStorageManager();
	
	/**
	 * Get the input dictionary containing data useful
	 * to perform the transaction.
	 * 
	 * @return The input data dictionary.
	 */
	public ReadableDictionary getInputDictionary();
}
