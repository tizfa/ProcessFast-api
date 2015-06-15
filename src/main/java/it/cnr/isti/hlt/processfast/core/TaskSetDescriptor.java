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

package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.utils.Function1;
import it.cnr.isti.hlt.processfast.utils.Pair;

import java.util.Iterator;


/**
 * A descriptor of a {@link TaskSet}.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskSetDescriptor extends RunnableDescriptor<TaskSetDescriptor> {
	
	/**
	 * Specify the set of virtual connectors declared in the corresponding task module that will be attached
	 * to connectors (physicals or virtuals) declared in the owning task module. 
	 * 
	 * @param func The function that given the tasks set information will returns a set of pairs
	 * [virtual_connector_name, connector_name_in_owner] indicating which connectors to link together.
	 * @return This task module descriptor.
	 */
	TaskSetDescriptor withAttachedVirtualConnectors(Function1<WithAttachedVirtualConnectorInfo, Iterator<Pair<String, String>>> func);


    /**
     * Specify the set of virtual barriers declared in the corresponding tasks set module that will be attached
     * to connectors (physicals or virtuals) declared in the owning tasks set module.
     *
     * @param func The function that given the tasks set information will returns a set of pairs
     * [virtual_barrier_name, barrier_name_in_owner] indicating which barriers to link together.
     * @return This task module descriptor.
     */
    TaskSetDescriptor withAttachedVirtualBarriers(Function1<WithAttachedVirtualBarrierInfo, Iterator<Pair<String, String>>> func);

}
	