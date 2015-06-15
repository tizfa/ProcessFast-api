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

import it.cnr.isti.hlt.processfast.exception.ConnectorIllegalOperationException;

import java.io.Serializable;

/**
 * The representation of the writer capabilities for a specific connector among tasks. 
 * <br/><br/>
 * This connector is
 * valid until the method {@link #signalEndOfStream()} is called. After that the corresponding
 * {@link ConnectorReader#getValue()} method will always get 'null' as return value.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ConnectorWriter {
	/**
	 * Put a value through this connector. The call is asynchronous.
	 * If the call {@link #signalEndOfStream()} was previously called on
	 * this connector, the stream will be automatically reopen.
	 * 
	 * @param v The value to put.
	 */
	void putValue(Serializable v);
	
	/**
	 * Put a value through this connector and wait for a result from
	 * the relative consumer. The call is asynchronous and returns a value promise which can be used later
	 * by the caller to retrieve the value. If the call {@link #signalEndOfStream()} was previously called on
	 * this connector, the stream will be automatically reopen.
	 * <br/>
	 * This operation is available only on connectors of type {@link ConnectorType#LOAD_BALANCING_QUEUE}.
	 * 
	 * @param v The value to put.
	 * @return The value promise for the result to obtain.
	 * @throws ConnectorIllegalOperationException Raised if the operation is requested on a connector that does not
	 * support it.
	 */
	ValuePromise<Serializable> putValueAndGet(Serializable v) throws ConnectorIllegalOperationException;

	
	/**
	 * Signal that that the task owning this connector will send no more data.
	 */
	void signalEndOfStream();
}
