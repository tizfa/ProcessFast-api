/*
 * *****************
 *  Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * *******************
 */

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
	Serializable getPayload();
	
	
	/**
	 * Indicate if the source that puts this message is waiting for a reply.
	 * 
	 * @return True if the source producer is waiting for a reply, false otherwise.
	 */
	boolean isWaitingReply();
	
	
	/**
	 * Reply a value to the original source producer of this request message. 
	 * 
	 * @param v The value to be replied.
	 */
	void replyValue(Serializable v);


    /**
     * Acknowledge the system that the message has been consumed.
     */
    //public void ack();
}
