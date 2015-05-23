package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.Dictionary;
import it.cnr.isti.hlt.processfast.data.StorageManager;

/**
 * Information to be used with {@link RunnableDescriptor#onFailure(it.cnr.isti.hlt.processfast.utils.Function1)}.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public interface FailureInfo extends TaskIdentifier {


    /**
     * Get the log manager provided by the system.
     *
     * @return The log manager provided by the system.
     */
    LogManager getLogManager();


    /**
     * Get the storage manager available in the running system.
     *
     * @return The storage manager available in the running system.
     */
    StorageManager getStorageManager();

    /**
     * Get the private data dictionary used to this runnable.
     *
     * @return The data dictionary.
     */
    Dictionary getDataDictionary();
}
