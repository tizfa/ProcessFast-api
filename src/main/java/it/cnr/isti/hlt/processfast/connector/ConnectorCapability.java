package it.cnr.isti.hlt.processfast.connector;

/**
 * The set of task capabilities available on a specific connector.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public enum ConnectorCapability {
	/**
	 * Request for read capability on a specific connector.
	 */
	READ,
	
	/**
	 * Request for write capability on a specific connector.
	 */
	WRITE,
	
	/**
	 * Request for read/write capabilities on a specific connector.
	 */
	READ_WRITE
}
