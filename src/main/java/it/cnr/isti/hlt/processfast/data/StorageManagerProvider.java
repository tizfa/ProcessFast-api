package it.cnr.isti.hlt.processfast.data;

/**
 * A generic storage manager provider.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface StorageManagerProvider {
    StorageManager getStorageManager(String clientID);

    /**
     * Open the connection to the storage manager pointed by this provider.
     */
    void open();

    /**
     * Close the connection to the storage managaer pointed by this provider.
     */
    void close();
}
