package it.cnr.isti.hlt.processfast.connector;

import java.util.Iterator;

/**
 * A controller of a connector. The controller have access to
 * special operations to manage the behaviour of the
 * owned connector.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ConnectorController extends Connector {

    /**
     * Freeze the connector by putting it in a state where it can
     * not receive new messages by {@link it.cnr.isti.hlt.processfast.connector.ConnectorWriter#putValue(java.io.Serializable)}
     * and can not deliver stored messages by using {@link ConnectorReader#getValue()}
     */
    void freeze();


    /**
     * Unfreeze the connector re-enabling it to receive new messages and to deliver stored messages.
     */
    void unfreeze();

    /**
     * Remove all messages stored on this connector.
     */
    void removeAllMessages();

    /**
     * Get an iterator over the set of stores messages IDs.
     *
     * @return An iterator over the set of stores messages IDs.
     */
    Iterator<String> getStoredMessagesIDs();


    /**
     * Get the stored message with the specified message ID.
     *
     * @param msgID The message ID.
     * @return The stored message or 'null' if the message can not be found.
     */
    ConnectorMessage getStoredMessage(String msgID);


    /**
     * Remove the message with specified ID.
     *
     * @param msgID The message ID to remove.
     */
    void removeStoredMessage(String msgID);
}
