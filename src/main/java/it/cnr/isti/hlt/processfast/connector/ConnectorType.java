package it.cnr.isti.hlt.processfast.connector;


/**
 * The available connectors types for data communications
 * among tasks.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0 
 */
public enum ConnectorType {
	/**
	 * A connector where is possible to write only one time and
	 * it is possible to read multiple times.
	 */
	SINGLE_VALUE,
	
	/**
	 * A data queue where multiple writers can store data. The data is distributed among
	 * readers: each reader get a different part of data by extracting a message from the
	 * head of the queue.
	 */
	LOAD_BALANCING_QUEUE,
	
	
	/**
	 * A data queue where multiple writers can store data. The data stored is passed 
	 * to readers. Every reader get the same set of messages in the order as they have
	 * written on the queue.
	 */
	BROADCAST_QUEUE,
	
}
