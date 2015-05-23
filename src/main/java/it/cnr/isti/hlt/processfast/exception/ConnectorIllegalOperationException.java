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

package it.cnr.isti.hlt.processfast.exception;

/**
 * An illegal operation has been called on a tasks connector.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class ConnectorIllegalOperationException extends  RuntimeException {

	private static final long serialVersionUID = 3330023728549998673L;

	private final String taskName;
	private final String connectorName;
	
	/**
	 * Build new instance.
	 * 
	 * @param taskName The name of task causing the exception.
	 * @param connectorName The name of the connector involved.
	 * @param msg The message details.
	 */
	public ConnectorIllegalOperationException(String taskName, String connectorName, String msg) {
		super(msg);
		
		this.taskName = taskName;
		this.connectorName = connectorName;
	}

	/**
	 * Get the name of the task causing the exception.
	 * 
	 * @return The name of the task causing the exception.
	 */
	public String getTaskName() {
		return taskName;
	}

	
	/**
	 * Get the name of the connector involved.
	 * 
	 * @return The name of the connector involved.
	 */
	public String getConnectorName() {
		return connectorName;
	}
	
	
}
