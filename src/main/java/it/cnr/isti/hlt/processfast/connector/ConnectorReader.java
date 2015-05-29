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
	ConnectorMessage getValue();
	
}
