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

/**
 * A generic representation of a Processfast runtime backend.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface ProcessfastRuntime {


    /**
     * Run the specified set of tasks.
     */
    void run(TaskSet taskSets);

    /**
     * Run a single instance of the specified task code. The task code can
     * be customized by passing parameter through the specified data dictionary. This dictionary can also be
     * used to return something at the end of the execution of the task.
     * <br/><br/>
     * NOTE: this method is useful to launch a program which exploits only data parallelism through partitionable
     * datatsets.
     *
     * @param dict The input/output data dictionary.
     * @param task The task to be executed.
     */
    void run(Dictionary dict, Task task);


    /**
     * Create a new tasks set.
     *
     * @return A new executable tasks set.
     */
    TaskSet createTaskSet();


}
