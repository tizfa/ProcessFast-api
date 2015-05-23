package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.Iterator;

import it.cnr.isti.hlt.processfast.core.TaskDataContext;
import it.cnr.isti.hlt.processfast.utils.Pair;
import it.cnr.isti.hlt.processfast.utils.Procedure3;

/**
 * A partitionable dataset which store items characterized by a key and
 * a value.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public interface PairPartitionableDataset<K extends Serializable, V extends Serializable> extends PartitionableDataset<Pair<K,V>> {
	/**
	 * Returns a dataset of (K, V) pairs
	 * where the values for each key are aggregated using the given reduce function.
	 * 
	 * @param func The reduce function.
	 * @return This partitionable dataset containing (K, V) pairs
	 * where the values for each key are aggregated using the given reduce function.
	 */
	public PairPartitionableDataset<K, V> reduceByKey(PDFunction2<V, V, V> func);
	
	
	/**
	 * Sort the items in the collection by ordering them by using its key value. The sort
	 * order is determined by "ascending" flag. The key must implements {@link java.lang.Comparable}
     * interface.
	 * 
	 * @param ascending True if the items must be ordered in ascending order, false in
	 * descendant order.
	 * @return This partitionable dataset containing with items ordered in the specified way.
	 */
	PairPartitionableDataset<K, V> sortByKey(boolean ascending);
	
	
	/**
	 * Return a collection by grouping elements by key. Each group consists of a key and a sequence of elements mapping to that key.
	 * 
	 * @return This partitionable dataset containing items grouped by key.
	 */
	public PairPartitionableDataset<K,DataIterable<V>> groupByKey();
	
	
	
	/**
	 * Join this [key, value] collection with the specified [key,value] collection by
	 * joining items using their key values.
	 * 
	 * @param dataset The dataset to join.
	 * @return This partitionable dataset containing joined items.
	 */
	public <T extends Serializable> PairPartitionableDataset<K, Pair<V, T>> join(PairPartitionableDataset<K, T> dataset);


	
	@Override
	public PairPartitionableDataset<K,V> cache(CacheType cacheType);
	
	@Override
	PairPartitionableDataset<K,V> saveOnStorageManager(Procedure3<TaskDataContext,StorageManager, Pair<K,V>> func);
	
	@Override
	public PairPartitionableDataset<K,V> enableLocalComputation(boolean enable);
	
}
