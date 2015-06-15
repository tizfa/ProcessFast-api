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

package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.Iterator;

/**
 * An interface for readonly dictionary.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ReadableDictionary {
	/**
	 * Indicate if the table contains or not data associated with specified key.
	 *
	 * @param key The key to check in the table.
	 * @return True if the table contains the given key, false otherwise.
	 */
	boolean containsKey(String key);
	
	
	/**
	 * Get the data associated with the specified key.
	 *
	 * @param key The key to search.
	 * @return The data associated with the specified key, or 'null' if the specified key
	 * is not contained in the table.
	 */
	<T extends Serializable> T get(String key);
	
	
	/**
	 * Get the set of keys stored on this dictionary.
	 * 
	 * @return The set of keys stored on this dictionary.
	 */
	Iterator<String> keySet();
	
	
	/**
	 * Get the number of [key, value] pairs contained in the dictionary.
	 * 
	 * @return The number of [key, value] pairs contained in the dictionary.
	 */
	long size();
}
