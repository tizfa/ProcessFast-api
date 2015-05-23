package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.connector.ValuePromise;

import java.util.List;

/**
 * A generic storages manager.
 * 
 * Each operation performed on managed storages and their data structures is atomic by default, so 
 * the programmer is responsible to guarantee a proper access
 * to the data structures in order to maintain the logical consistency of the
 * data. If a programmer need to perform a logical set of operations atomically on several
 * data structures, he can
 * use {@link #atomic(ReadableDictionary, AtomicOperationsSet)} or
 * {@link #atomicGet(ReadableDictionary, AtomicGetOperationsSet)} methods to execute
 * the wanted operations.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface StorageManager {
	/**
	 * Get the set of storages declared on this manager.
	 * 
	 * @return The set of storages available on this manager.
	 */
	List<String> getStorageNames();
	
	/**
	 * Check if the specified storage is declared on this manager.
	 * 
	 * @param name The name of the storage to check.
	 * @return True if the requested storage exists, false otherwise.
	 */
	boolean containsStorageName(String name);
	
	/**
	 * Create a new storage. If a storage with this name already exists, the
	 * method will return it.
	 * 
	 * @param name The name of the new storage.
	 * @return The corresponding storage.
	 */
	public Storage createStorage(String name);
	
	/**
	 * Remove a specific storage.
	 * 
	 * @param name The name of the storage to remove.
	 */
	public void removeStorage(String name);
	
	/**
	 * Get a specific storage.
	 * 
	 * @param name The name of the storage to retrieve.
	 * @return The requested storage or 'null' if the storage can not be found.
	 */
	public Storage getStorage(String name);
		
	
	/**
	 * Flush the data of all contained data structures, eventually stored locally in memory, to 
	 * the destination storage.
	 */
	public void flushData();
	
	
	/**
	 * Exec atomically the specified set of operations on this storage manager. The
	 * execution of the operations is done asynchronously respect to
	 * the method call. To maximize throughput, each set of operations will be
	 * executed optimistically. In case of data conflicts, the system will abort
	 * the considered set of operations and will retry to perform it until successful completion.
	 * 
	 * @param inputData The input data dictionary.
	 * @param operations The set of operations to be executed.
	 */
	public ValuePromise<Void> atomic(ReadableDictionary inputData, AtomicOperationsSet operations);


    /**
     * Exec atomically the specified set of operations on this storage manager. The
     * execution of the operations is done asynchronously respect to
     * the method call. To maximize throughput, each set of operations will be
     * executed optimistically. In case of data conflicts, the system will abort
     * the considered set of operations and will retry to perform it until successful completion.
     *
     * @param operations The set of operations to be executed.
     */
    public ValuePromise<Void> atomic(AtomicOperationsSet operations);

	
	/**
	 * Exec atomically the specified set of operations on this storage manager. The execution of
	 * the operations is done synchronously and can return output data to the caller in the
	 * form of a data dictionary. To maximize throughput, each set of operations will be
	 * executed optimistically. In case of data conflicts, the system will abort
	 * the considered set of operations and will retry to perform it until successful completion.
	 * 
	 * @param inputData The input data dictionary.
	 * @param operations The set of operations to be executed.
	 * @return The output data from the set of operations executed.
	 */
	public ValuePromise<ReadableDictionary> atomicGet(ReadableDictionary inputData, AtomicGetOperationsSet operations);



    /**
     * Exec atomically the specified set of operations on this storage manager. The execution of
     * the operations is done synchronously and can return output data to the caller in the
     * form of a data dictionary. To maximize throughput, each set of operations will be
     * executed optimistically. In case of data conflicts, the system will abort
     * the considered set of operations and will retry to perform it until successful completion.
     *
     * @param operations The set of operations to be executed.
     * @return The output data from the set of operations executed.
     */
    public ValuePromise<ReadableDictionary> atomicGet(AtomicGetOperationsSet operations);


    /**
     * Delete all data stored on this storage container.
     */
    void clear();
}
