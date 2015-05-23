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
	public <T extends Serializable> Dictionary put(String key, T data);
	
	
	/**
	 * Put all items defined in the specified map into this dictionary. Each entry key already existent on this dictionary
	 * and stored also on the specified map will be overwritten by those contained in the map.
	 * 
	 * @param map The map of values to add.
	 * @return This dictionary.
	 */
	public <T extends Serializable> Dictionary putAll(Map<String, T> map);
	
	
	
	
	/**
	 * Remove the key/data couple identified by given key from this table. If the table does not
	 * contain the given key, the method will do anything.
	 * 
	 * @param key The key to search.
	 * @return This dictionary.
	 */
	public Dictionary remove(String key);
}
