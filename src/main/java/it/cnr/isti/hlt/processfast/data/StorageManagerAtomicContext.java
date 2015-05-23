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
