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

package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.core.TaskDataContext;
import it.cnr.isti.hlt.processfast.utils.Pair;
import it.cnr.isti.hlt.processfast.utils.Procedure3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


/**
 * A partitionable dataset. 
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <T> The type od data handled by this dataset.
 */
public interface PartitionableDataset<T extends Serializable> {
	
	/**
	 * Indicate to the runtime system on how to perform next
	 * data transformations.
	 * 
	 * @param enable If true the system must perform the next transformations
	 * and data computations locally on the same machine of the caller task, if false
     * the system is free to choose to perform next computations either locally or remotely
	 * @return This partitionable dataset.
	 */
	public PartitionableDataset<T> enableLocalComputation(boolean enable);
	
	
	/**
	 * Suggest to the runtime how to size each partition of the dataset. Each partition
	 * will be processed in RAM by a set of processors.
	 * 
	 * @param partitionSize The number of items assigned to a partition.
	 * @return This partitionable dataset.
	 */
	public PartitionableDataset<T> withPartitionSize(int partitionSize);

	
	/**
	 * Compute current data and cache results on the specified cache type. 
	 * 
	 * @param cacheType The cache type.
	 * @return A new partitionable dataset containing the current results coming from current configuration of this
     * partitionable dataset.
	 */
	public PartitionableDataset<T> cache(CacheType cacheType);
	
	
	
	///////////////////  TRANSFORMATIONS on data  ///////////////////////////////////
	
	/**
	 * Apply the specified function to every item in the data collection and returns a
	 * new dataset with where each item is the output of specified function.
	 * 
	 * 
	 * @param func The function to apply.
	 * @return This partitionable dataset including data available after the call of "func".
	 */
	public <Out extends Serializable> PartitionableDataset<Out> map(PDFunction<T, Out> func);
	
	/**
	 * Map each collection value to a couple [key,value].
	 * 
	 * @param func The transformation function to apply.
	 * @return This partitionable dataset containing couples [key, value].
	 */
	public <K extends Serializable,V extends Serializable> PairPartitionableDataset<K, V> mapPair(PDPairFunction<T, K, V> func);
	
	
	/**
	 * Return a new data collection containing only the items matching the filter function.
	 * 
	 * @param func The filter function.
	 * @return This partitionable dataset including only the items matching (value equals to 'true') the filter function.
	 */
	public PartitionableDataset<T> filter(PDFunction<T, Boolean> func);
	
	
	
	
	/**
	 * Apply the specified function to every item in the data collection and returns a
	 * new dataset with where each item is mapped to 0 or more items.
	 *
	 *
	 * @param func The function to apply.
	 * @return This partitionable dataset including data available after the call of "func".
	 */
	public <Out extends Serializable> PartitionableDataset<Out> mapFlat(PDFunction<T, Iterator<Out>> func);
	
	
	/**
	 * Return a new data collection containing the union of this dataset with the specified
	 * dataset. The resulting dataset may contains duplicate items. The equality between items is
	 * checked according to equals() and hashCode() methods. 
	 * 
	 * @param dataset The dataset to merge with.
	 * @return This partitionable dataset containing the union of this dataset with the specified
	 * dataset.
	 */
	public  PartitionableDataset<T> union(PartitionableDataset<T> dataset);



    /**
     * Return a new data collection by pairing the items of this dataset with the items of the specified
     * dataset. Supposing this dataset has items [v1, v2, etc...] and the specified dataset has items [s1, s2, etc.],
     * the computed dataset will have items of the form [[v1,s1], [v2,s2], etc.]. If the size of datasets is different,
     * then the computed dataset will have a size equals to min(count(), dataset.count()).
     *
     * @param dataset The dataset to merge with.
     * @return This partitionable dataset containing the union of this dataset with the specified
     * dataset.
     */
    public  <T1 extends Serializable> PartitionableDataset<Pair<T,T1>> pair(PartitionableDataset<T1> dataset);


	
	/**
	 * Return a new dataset which is the intersection of this collection with the specified
	 * dataset. The equality between items is
	 * checked according to equals() and hashCode() methods. 
	 * 
	 * @param dataset The dataset to intersect with.
	 * @return This partitionable dataset containing the intersection of the data.
	 */
	public PartitionableDataset<T> intersection(PartitionableDataset<T> dataset);


    /**
     * Compute a partitionable dataset containing only distinct values. The items are
     * matched using {@link T#equals(Object)} method.
     *
     * @return This partitionable dataset.
     */
	public PartitionableDataset<T> distinct();


    /**
     * Compute a partitionable dataset containing sorted data. The type of the data where
     * this transformation is called must implement {@link java.lang.Comparable} interface.
     *
     * @param sortAscending True to sort data in ascending order, false to sort data in
     *                      descending order.
     * @return This partitionable dataset.
     */
    public PartitionableDataset<T> sort(boolean sortAscending);
	
	
	/**
	 * Return a collection of grouped elements. Each group consists of a key and a sequence of elements mapping to that key.
	 * 
	 * @param func The function that associate each item to a specific key.
	 * @return A new partitionable dataset with items grouped by key.
	 */
	public <K extends Serializable> PairPartitionableDataset<K,DataIterable<T>> groupBy(PDFunction<T,K> func);
	
	
	
	/**
	 * Return a collection which is the cartesian product (all possible couples between items) between 
	 * this collection and the specified dataset.
	 * 
	 * @param dataset The datasource to merge with.
	 * @return A new  partitionable dataset containing the cartesian product between
	 * this collection and the specified dataset.
	 */
	public <U extends Serializable> PairPartitionableDataset<T, U> cartesian(PartitionableDataset<U> dataset);
	
	
	
	
	
	
	
	///////////////////// Actions on data   /////////////////////////////////////
	
	
	/**
	 * Reduce all items to a single result by using an associative and commutative function applied as
	 * a binary operator.
	 * 
	 * @param func The function to apply.
	 * @return The result coming from cumulative computation of "func".
	 */
	public T reduce(PDFunction2<T, T, T> func);
	
	
	
	
	/**
	 * Collect collection's items and return them into a list.
	 * 
	 * @return The items contained in this collection.
	 */
	public List<T> collect();
	
	
	
	/**
	 * Count the number of items in the collection.
	 * 
	 * @return The number of items in the collection.
	 */
	public long count();


    /**
     * Check if the current partitionable dataset contains the specified item. The
     * check is made by using the standard  {@link T#equals(Object)} method.
     *
     * @param item The item to check.
     * @return True if the item is contained in the partitionable dataset, false otherwise.
     */
    boolean contains(T item);

	
	/**
	 * Get a subset of this collection composed by items starting at
	 * position "startFrom" and extending to index [startFrom + numItems] excluded.
	 * 
	 * @param startFrom The index where to start from.
	 * @param numItems The number of items to include in the returned list.
	 * @return A specific subcollection of this data collection.
	 */
	List<T> take(long startFrom, long numItems);
	
	/**
	 * Save the current collection's items on the specified storage manager. This method
	 * could be executed in parallel.
	 * 
	 * @param func The function which specify where to save data. The function parameters are:
	 * the context, the storage manager shared with other tasks and
	 * the data to save.
	 * @return This partitionable dataset.
	 */
	PartitionableDataset<T> saveOnStorageManager(Procedure3<TaskDataContext,StorageManager, T> func);


    /**
     * Apply the specified function to every item in the data collection. The function is invoked
     * concurrently on each item of the collection, so the function code should be thread safe on
     * every critical data structure it modifies.
     *
     *
     * @param func The function to apply.
     * @return This partitionable dataset including data available after the call of "func".
     */
    public  void processEach(PDProcedure<T> func);


    /**
     * Release all allocated resources.
     */
    void close();
}
