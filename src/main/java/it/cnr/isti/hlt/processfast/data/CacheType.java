package it.cnr.isti.hlt.processfast.data;

/**
 * The cache type to use.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public enum CacheType {
	
	/**
	 * Cached in RAM.
	 */
	RAM,
	
	/**
	 * Cached serialized on secondary storage.
	 */
	ON_DISK
}
