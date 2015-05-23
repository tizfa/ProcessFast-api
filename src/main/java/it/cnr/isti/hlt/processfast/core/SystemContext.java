package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.StorageManager;

/**
 * A context used to access Processfast runtime global resources.  
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface SystemContext {
	/**
	 * Get the log manager provided by the system. The log manager is shared among
	 * all tasks and tasks sets defined in a specific program.
	 * 
	 * @return The log manager provided by the system.
	 */
	LogManager getLogManager();
	
	
	/**
	 * Get the storage manager available on the system. The storage manager and
	 * all its contained data structures are shared among
	 * all tasks and tasks sets defined in a specific program.
	 * 
	 * @return The storage manager available on the system.
	 */
	StorageManager getStorageManager();
		
}
