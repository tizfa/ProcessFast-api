/*
 *
 * ****************
 * Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
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
 * ******************
 */

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
