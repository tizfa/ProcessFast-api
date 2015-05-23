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
	public <T extends Serializable> T get(String key);
	
	
	/**
	 * Get the set of keys stored on this dictionary.
	 * 
	 * @return The set of keys stored on this dictionary.
	 */
	public Iterator<String> keySet();
	
	
	/**
	 * Get the number of [key, value] pairs contained in the dictionary.
	 * 
	 * @return The number of [key, value] pairs contained in the dictionary.
	 */
	public long size();
}
