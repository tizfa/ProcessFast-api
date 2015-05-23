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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A thread-safe dictionary in RAM.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class RamDictionary implements Dictionary {

	private final HashMap<String, Serializable> items;
	
	public RamDictionary() {
		items = new HashMap<String, Serializable>();
	}
	
	@Override
	public synchronized  boolean containsKey(String key) {
		return items.containsKey(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T get(String key) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("The key is 'null' or empty");
		
		return (T) items.get(key);
	}

	@Override
	public synchronized Iterator<String> keySet() {
		return items.keySet().iterator();
	}

	@Override
	public synchronized Dictionary clear() {
		items.clear();
		return this;
	}

	@Override
	public synchronized <T extends Serializable> Dictionary put(String key, T data) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("The key is 'null' or empty");
		if (data == null)
			throw new NullPointerException("The data is 'null'");
		
		items.put(key, data);
		return this;
	}

	@Override
	public synchronized Dictionary remove(String key) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("The key is 'null' or empty");
		items.remove(key);
		return this;
	}

	@Override
	public synchronized <T extends Serializable> Dictionary putAll(Map<String, T> map) {
		if (map == null)
			throw new NullPointerException("The specified map is 'null'");
		items.putAll(map);
		return this;
	}

	@Override
	public synchronized long size() {
		return items.size();
	}

}
