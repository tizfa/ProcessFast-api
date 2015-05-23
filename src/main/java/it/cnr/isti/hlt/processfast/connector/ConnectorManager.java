package it.cnr.isti.hlt.processfast.connector;

import it.cnr.isti.hlt.processfast.core.TaskDescriptor;

/**
 * A system connector manager.
 * 
 * The set of connections linking tasks together is defined statically during 
 * the definition of the complete program.
 *  
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ConnectorManager {
	
	/**
	 * Attach the task identified by "taskName" to the connector
	 * identified by "connectorName".
	 * 
	 * @param taskName The name of the task (as identified by {@link TaskDescriptor#withName(it.cnr.isti.hlt.processfast.utils.Function1)} method).
	 * @param connectorName The name of the connector.
	 * @param capability The set of capabilities to assign to the task over the specified
	 * connector.
	 */
	void attachTaskToConnector(String taskName, String connectorName, ConnectorCapability capability);
}
