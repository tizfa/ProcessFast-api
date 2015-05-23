package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.Dictionary;

/**
 * The data shared by a task in a call of a transformation or an action on a
 * partitionable dataset. This interface allow to define which data must share
 * with a transformation or action in a partitionable dataset.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface WritableTaskSharedData {
	/**
	 * Get the data dictionary to share in a transformation or action in
	 * a partitionable dataset.
	 * 
	 * @return The data dictionary to share
	 */
	Dictionary getDataDictionary();
}
