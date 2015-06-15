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

package it.cnr.isti.hlt.processfast.exception;

import java.util.List;

/**
 * An exception occurred when one or more logical virtual machines
 * died unexpectedly.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface VirtualMachineException {
	/**
	 * Get the list of virtual machines died unexpectedly.
	 * 
	 * @return The list of virtual machines died unexpectedly.
	 */
	List<String> getVMs();
	
	
	
	/**
	 * Get the throwable which describes the exception occurred. 
	 * 
	 * @return The throwable which describes the exception occurred. 
	 */
	Throwable getCausingThrowable();
}
