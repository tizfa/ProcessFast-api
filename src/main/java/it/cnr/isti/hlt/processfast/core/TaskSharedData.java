package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.ReadableDictionary;

/**
 * Access to the the data shared by a task in a call of a transformation or an action on a
 * partitionable dataset.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskSharedData {
	/**
	 * Get the data dictionary.
	 * 
	 * @return The data dictionary.
	 */
	ReadableDictionary getDataDictionary();
}
