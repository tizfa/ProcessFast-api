package it.cnr.isti.hlt.processfast.connector;

import java.util.List;

/**
 * A connector manager to be used by application tasks.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskConnectorManager {

    /**
     * Get read access to the connector with the given name. The specified connector
     * is available to this task only if this was declared by the proper usage
     * of {@link ConnectorManager#attachTaskToConnector(String, String, ConnectorCapability)}
     * method.
     *
     * @param name The name of the connector.
     * @return The requested connector or 'null' if it can not be found.
     */
    public ConnectorReader getConnectorReader(String name);


    /**
     * Get write access to the connector with the given name. The specified connector
     * is available to this task only if this was declared by the proper usage
     * of {@link ConnectorManager#attachTaskToConnector(String, String, ConnectorCapability)}
     * method.
     *
     * @param name The name of the connector.
     * @return The requested connector or 'null' if it can not be found.
     */
    public ConnectorWriter getConnectorWriter(String name);

    /**
     * Get the first connector ready to provide a value to the caller task. The caller
     * is blocked until one of the specified connector is able to provide a new msg to
     * the caller.
     *
     * @param connectors  The set of connectors to choose from.
     * @param maxWaitTime The maximum time in milliseconds to wait for a connector to become ready to provide
     *                    a useful msg or -1 to wait indefinitely for a msg.
     * @return The selected connector or 'null' if the maxWaitTime has passed and no connector was selected.
     */
    public ConnectorReader getReadyConnectorReader(List<String> connectors, long maxWaitTime);


    /**
     * Get the first connector ready to provide a value to the caller task. The caller
     * is blocked until one of the specified connector is able to provide a new msg to
     * the caller. If there are several connectors ready at the same time, the system will
     * return the connector with highest priority.
     *
     * @param connectors  The set of connectors to choose from. The order of the connectors determines the priority
     *                    assigned to the connector itself. The connector at index 0 will be the connector
     *                    with highest priority.
     * @param maxWaitTime The maximum time to wait for a connector to become ready to provide
     *                    a useful msg or -1 to wait indefinitely for a msg.
     * @return The selected connector or 'null' if the maxWaitTime has passed and no connector was selected.
     */
    public ConnectorReader getReadyConnectorReaderWithPriority(List<String> connectors, long maxWaitTime);
}
