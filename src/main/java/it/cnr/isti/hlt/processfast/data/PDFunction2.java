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

package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.core.TaskDataContext;

/**
 * A generic 2-input parameters function interface to be called on
 * partitionable dataset.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * @param <In1> The type of 1st parameter.
 * @param <In2> The type of 2nd parameter.
 * @param <Out> The type of function output.
 * 
 * @since 1.0.0
 */
public interface PDFunction2<In1, In2,Out> {
	
	/**
	 * Call the function.
	 * 
	 * @param ctx The task context where the function is called.
	 * @param par1 The first parameter of the function.
	 * @param par2 The second parameter of the function.
	 * @return The corresponding output.
	 */
	Out call(TaskDataContext ctx, In1 par1, In2 par2);
}
