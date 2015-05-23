package it.cnr.isti.hlt.processfast.connector;

/**
 * The representation of the reader capabilities for a specific connector among tasks.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ConnectorReader {

	/**
	 * Get the name of this connector.
	 *
	 * @return The name of this connector.
	 */
	String getConnectorName();

	/**
	 * Get the next message from this connector or 'null' if
	 * the connector will give no more data. A physical connector can have multiply writers
	 * on it. A task will receive no more data only when all declared writers have signaled
	 * that have ended sending data through the use of their respective 
	 * {@link ConnectorWriter#signalEndOfStream()}.
	 * 
	 * @return The next message to process from this connector or 'null' if the connector will
	 * give no more data.
	 */
	public ConnectorMessage getValue();
	
}
