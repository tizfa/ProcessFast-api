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
import java.util.Map;

/**
 * A generic dictionary table.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface Dictionary extends ReadableDictionary {


	/**
	 * Remove all items from dictionary.
	 * 
	 * @return This dictionary.
	 */
	Dictionary clear();
	
	/**
	 * Store the specified data on the table and associate it with the given key. If the table
	 * already contains a data with specified key, the new data will
	 * overwrite the old data in the table.
	 * 
	 * @param key The key identifying data.
	 * @param data The data to be stored.
	 * @return This dictionary.
	 */
	<T extends Serializable> Dictionary put(String key, T data);
	
	
	/**
	 * Put all items defined in the specified map into this dictionary. Each entry key already existent on this dictionary
	 * and stored also on the specified map will be overwritten by those contained in the map.
	 * 
	 * @param map The map of values to add.
	 * @return This dictionary.
	 */
	<T extends Serializable> Dictionary putAll(Map<String, T> map);
	
	
	
	
	/**
	 * Remove the key/data couple identified by given key from this table. If the table does not
	 * contain the given key, the method will do anything.
	 * 
	 * @param key The key to search.
	 * @return This dictionary.
	 */
	Dictionary remove(String key);
}
