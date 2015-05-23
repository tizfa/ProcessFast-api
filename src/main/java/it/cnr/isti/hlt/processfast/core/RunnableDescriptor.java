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

package it.cnr.isti.hlt.processfast.core;

import it.cnr.isti.hlt.processfast.data.Dictionary;
import it.cnr.isti.hlt.processfast.utils.Function1;
import it.cnr.isti.hlt.processfast.utils.Function2;
import it.cnr.isti.hlt.processfast.utils.Pair;

import java.util.Iterator;

/**
 * A common descriptor for something runnable by the system.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface RunnableDescriptor<T> {


    /**
     * Specify on which virtual machine exec a specific task. If you want to run tow different tasks on
     * the same virtual machine just specify the same virtual machine name.
     * <p>
     * <br/>  <br/>
     * WARNING: The function code could be executed on a remote machine, so the code
     * must not access variables outside the scope of the function.
     *
     * @param machineSelector The function that given the task instance information return a proper name
     *                        of the virtual machine where the task should be executed.
     * @return This descriptor.
     */
    T onVirtualMachine(Function1<WithVirtualMachineInfo, String> machineSelector);

    /**
     * Indicate to the runtime the minimum and maximum number of instances of this task that could be created by the
     * system. The default range assigned by the system is (1,1). The system could be use these values to adjust dynamically
     * the number of instances of some tasks in order to guarantee a proper level of quality for performance.
     *
     * @param minNumInstances The minimum number of instances to create.
     * @param maxNumInstances The maximum number of instances to create. This must always be greater equals than
     *                        specified minimum number.
     * @return This descriptor.
     */
    T withNumInstances(int minNumInstances, int maxNumInstances);


    /**
     * Specify the name associated with a specific task.
     * <p>
     * <br/>  <br/>
     * WARNING: The function code could be executed on a remote machine, so the code
     * must not access variables outside the scope of the function.
     *
     * @param nameSelector The function that given a the task instance returns the proper name of the task.
     * @return This descriptor.
     */
    T withName(Function1<Integer, String> nameSelector);


    /**
     * This sets the relative priority of this task in computational
     * resources allocation for data parallelism. The
     * relative priority is measured among all defined tasks in the tasks set. The default value
     * assigned by the system is 1.
     *
     * @param priority The priority assigned to this task.
     * @return This descriptor.
     */
    T withDataComputationalResourcesPriority(int priority);


    /**
     * Used to pass some data specific to a runnable instance.
     *
     * @param dictionary The input data available
     * @param func       The function that given the task identifier and the input data available compute a set of data to be
     *                   passed at runtime to this specific runnable instance.
     * @return This descriptor.
     */
    T withDataDictionary(Dictionary dictionary, Function1<WithDataDictionaryInfo, Dictionary> func);


    /**
     * Used to pass some data specific to a runnable instance.
     *
     * @param func The function that given the task identifier compute a set of data to be
     *             passed at runtime to this specific runnable instance.
     * @return This descriptor.
     */
    T withDataDictionary(Function1<WithDataDictionaryInfo, Dictionary> func);


    /**
     * Used to specify to the system what to do in cause of task abnormal termination due to
     * hardware failure. If the programmer does not specify anything, the default behaviour is
     * the same as {@link it.cnr.isti.hlt.processfast.core.HardwareFailureAction#ASK_PARENT}. In case of
     * failure of a runnable in the main tasks set and with no behaviour specified,
     * the application will be terminated.
     *
     * @param func The function which specify to the system what to do when this runnable terminates
     *             due to hardware failure.
     * @return This descriptor.
     */
    T onFailure(Function1<FailureInfo, HardwareFailureAction> func);
}
