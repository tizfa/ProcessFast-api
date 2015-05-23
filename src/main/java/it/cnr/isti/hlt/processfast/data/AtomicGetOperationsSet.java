package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.connector.ValuePromise;

/**
 * A set of operations to be executed on a storage manager which return some results
 * stored on a dictionary.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 */
public interface AtomicGetOperationsSet {
	/**
	 * Call the function to perform the code.
	 * 
	 * @param ctx The context to use.
	 * @return The output data to be returned from the set of operations executed.
	 */
	 public ReadableDictionary call(StorageManagerAtomicContext ctx);
}
