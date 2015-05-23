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

/**
 * Identifier of a processfast task.
 *
 * Created by Tiziano Fagni on 30/01/2015.
 */
public interface TaskIdentifier {
    /**
     * Get the instance number of the invoking task. The number of instances of
     * a specific task is specified to the system by using {@link TaskDescriptor#withNumInstances(int, int)}
     * method. The instance number goes
     * in the range [0, {@link #getNumTotalInstances()}-1] included.
     *
     * @return The instance number.
     */
    int getInstanceNumber();


    /**
     * Get the current number of total instances created for this task.
     *
     * @return The current number of total instances created for this task.
     */
    int getNumTotalInstances();


    /**
     * Get the name of this task. The name is unique among all declared tasks and
     * tasks sets defined in the containing tasks set. The name is assigned explicitly by using
     * {@link TaskDescriptor#withName(it.cnr.isti.hlt.processfast.utils.Function1)} for a task or
     * {@link TaskSetDescriptor#withName(it.cnr.isti.hlt.processfast.utils.Function1)} for a tasks set, or
     * is assigned implicitly by the system if not assigned directly from the programmer.
     *
     * @return The name of this task.
     */
    String getTaskName();


}
