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

import it.cnr.isti.hlt.processfast.connector.TaskConnectorManager;
import it.cnr.isti.hlt.processfast.data.*;
import it.cnr.isti.hlt.processfast.utils.Pair;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * A context used to access Processfast runtime from a specific task.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface TaskContext extends SystemContext, TaskIdentifier {



    /**
     * Make a checkpoint by saving information on the specified storages and structures. The checkpoint scope is
     * for the owning {@link TaskSet}.
     *
     * @param checkpointName The name of checkpoint.
     * @param data The set of storage parts info to save.
     */
    public void makeCheckpoint(String checkpointName, List<CheckpointDataInfo> data);

    /**
     * Load the last executed checkpoint name on the owning {@link TaskSet} by reloading the related data structures. Every storage
     * and relates structures saved on last call of {@link #makeCheckpoint} will replace the
     * content of current values in the same storages and related structures.
     *
     * @param checkpointName The name of checkpoint.
     */
    public void loadCheckpoint(String checkpointName);


    /**
     * Delete the last executed checkpoint on the owning {@link TaskSet}. After this call, calling {@link #loadCheckpoint(String)} has
     * no effects until a new call to {@link #makeCheckpoint(String, java.util.List)} is made.
     *
     * @param checkpointName The name of checkpoint to delete.
     */
    public void deleteCheckpoint(String checkpointName);

	
	
	/**
	 * Suspend the task while waiting that all registered tasks have joined the
	 * specified barrier. After a barrier has been completed, the state of the
	 * barrier is reset to its initial state so it can be used to perform another
	 * synchronization.
	 * <br/><br/>
	 * The barriers are all declared inside the scope of the {@link TaskSet} owning this task. A task
	 * must explicitly declare which barriers need to use by using the method 
	 * {@link TaskDescriptor#withBarriers(it.cnr.isti.hlt.processfast.utils.Function1)}.
	 * 
	 * @param barrierName The barrier name.
	 */
	void barrier(String barrierName);





	
	/**
	 * Create a partitionable dataset from the specified data source.
	 * 
	 * @param dataSource The input data source.
	 * @return A partitionable dataset.
	 */
	public <T extends Serializable> PartitionableDataset<T> createPartitionableDataset(ImmutableDataSourceIteratorProvider<T> dataSource);
	
	
	/**
	 * Create a pair partitionable dataset from the specified data source.
	 * 
	 * @param dataSource The input data source.
	 * @return A partitionable dataset.
	 */
	public <K extends Serializable,V extends Serializable> PairPartitionableDataset<K,V> createPairPartitionableDataset(ImmutableDataSourceIteratorProvider<Pair<K,V>> dataSource);
	
	
	/**
	 * Create a pair partitionable dataset from the specified set of data sources. The resulting
	 * dataset will have items where the key is the index of the original data sources set and the
	 * value is an iterator over the corresponding items.
	 * 
	 * @param dataSources The set of datasources.
	 * @return A partitionable dataset.
	 */
	public  <K extends Serializable,V extends Serializable> PairPartitionableDataset<K,DataIterable<V>> createPairPartitionableDataset(Iterator<ImmutableDataSourceIteratorProvider<V>> dataSources);
	
	
	/**
	 * Get the data dictionary provided by the owning {@link TaskSet}. This dictionary is
	 * shared among all defined tasks.
	 * 
	 * @return The data dictionary.
	 */
	Dictionary getTasksSetDataDictionary();


	/**
	 * Get the private data dictionary of this task. The task dictionary is
     * specified by using {@link it.cnr.isti.hlt.processfast.core.RunnableDescriptor#withDataDictionary(it.cnr.isti.hlt.processfast.data.Dictionary, it.cnr.isti.hlt.processfast.utils.Function1)}
     * method.
	 *
	 * @return The data dictionary.
	 */
	Dictionary getPrivateTaskDataDictionary();
	
	
	/**
	 * Get the task connector manager.
	 * 
	 * @return The task connector manager.
	 */
	TaskConnectorManager getConnectorManager();
}
