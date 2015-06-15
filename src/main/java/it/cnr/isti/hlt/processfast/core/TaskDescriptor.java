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
import it.cnr.isti.hlt.processfast.utils.Procedure1;

import java.util.Iterator;

/**
 * Used to specify information about a task.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskDescriptor extends RunnableDescriptor<TaskDescriptor> {


    /**
     * Used to specify which connectors (new created or existent) must be attached to this task.
     *
     * <br/>  <br/>
     * WARNING: The function code could be executed on a remote machine, so the code
     * must not access variables outside the scope of the function.
     *
     * @param func The function that given information about the task instance,
     * specify which connectors this task will use during the execution of the program.
     * @return This task descriptor.
     */
    TaskDescriptor withConnectors(Procedure1<WithConnectorInfo> func);





    /**
     * Declare which barriers will be used by each task instance.
     *
     * @param barriers The set of barriers used by each task instance.
     * @return This descriptor.
     */
    TaskDescriptor withBarriers(Function1<WithBarrierInfo, Iterator<String>> barriers);


}


