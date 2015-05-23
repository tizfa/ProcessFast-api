package it.cnr.isti.hlt.processfast.data;

/**
 * A set of operations on a storage manager to be executed without returning results.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 */
public interface AtomicOperationsSet {
	/**
	 * Call the function.
	 * 
	 * @param ctx The context to use.
	 */
	 public void call(StorageManagerAtomicContext ctx);
}
