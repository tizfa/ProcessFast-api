package it.cnr.isti.hlt.processfast.connector;

import java.io.Serializable;

/**
 * This is a message stored and read from a specific connector.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ConnectorMessage {
	
	/**
	 * Get the "real" value packaged with this message.
	 * 
	 * @return The "real" value packaged with this message.
	 */
	public Serializable getPayload();
	
	
	/**
	 * Indicate if the source that puts this message is waiting for a reply.
	 * 
	 * @return True if the source producer is waiting for a reply, false otherwise.
	 */
	public boolean isWaitingReply();
	
	
	/**
	 * Reply a value to the original source producer of this request message. 
	 * 
	 * @param v The value to be replied.
	 */
	public void replyValue(Serializable v);


    /**
     * Acknowledge the system that the message has been consumed.
     */
    //public void ack();
}
