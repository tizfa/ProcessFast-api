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

import it.cnr.isti.hlt.processfast.utils.Pair;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * A sparse array containing items of a specific type. The array can grow dynamically by appending
 * values at its end or can be truncated at a specific size.
 *
 * @param <T> The type of items stored on the array.
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface Array<T extends Serializable> {


    /**
     * Get the array name.
     *
     * @return The array name.
     */
    String getName();

    /**
     * Get the size of the array.
     *
     * @return The size of this array.
     */
    long size();


    /**
     * Get the value of array item specified by given index.
     *
     * @param index The index to access in the array.
     * @return The value corresponding to requested index. The value can eventually be 'null'.
     */
    T getValue(long index);


    /**
     * Get the array values specified in the interval [fromIndex, toIndex). In case "toIndex" is
     * greater than {@link #size()}, the returned values will be in the
     * interval [fromIndex, size()).
     *
     * @param fromIndex The start index included.
     * @param toIndex   The end index excluded.
     * @return The set of values read.
     */
    List<T> getValues(long fromIndex, long toIndex);


    /**
     * Set the specified value in the array at the given index.
     *
     * @param index The item index to set.
     * @param value The value to set. The value can be 'null'.
     */
    void setValue(long index, T value);

    /**
     * Append the specified value to the end of this array.
     *
     * @param value The value to append. The value can be 'null'.
     */
    void appendValue(T value);


    /**
     * Append "numItems" items with the specified value to the end of this array.
     *
     * @param numItems The number of items to add.
     * @param value    The value to set. The value can be 'null'.
     */
    void appendValues(long numItems, T value);


    /**
     * Get the default value used for items not assigned in sparse representation.
     *
     * @return The default value used for items not assigned in sparse representation.
     */
    T getDefaultValue();

    /**
     * Set the default value to use when accessing an item not having a user
     * specified value in the sparse representation.
     *
     * @param defaultValue The default value used for items not assigned in sparse representation. The value can be 'null'.
     */
    void setDefaultValue(T defaultValue);


    /**
     * Remove all items from this array by truncating it to size 0.
     */
    void clear();


    /**
     * Resize the array to specified number of items. If current size
     * is less than required number of items, the array will be
     * expanded to match this new size and the new items will have the
     * value specified by {@link #getDefaultValue()}. If current
     * size is greater than requested size, the array will be truncated
     * to the requested size.
     *
     * @param newSize The new size of the array.
     */
    void resize(long newSize);


    /**
     * Return an iterator over the set of items in this array. The user must specify
     * how many items to read at time from teh source storage.
     *
     * @param numBufferedItems The number of items to buffer.
     * @return A new iterator over the set of items in this array.
     */
    Iterator<T> asIterator(long numBufferedItems);

    /**
     * Clear current array content and copy the items from source array into this array.
     *
     * @param source            The source array to copy from.
     * @param clearArrayContent True if before copying items the content of this array will be erased, false
     *                          if the new items will be appended to the content of this array.
     * @param numBufferedItems  The number of items to buffer while doing the copy.
     * @return This array.
     */
    Array<T> copyFrom(Array<T> source, boolean clearArrayContent, long numBufferedItems);

    /**
     * Clear current array content and copy the items from source collection into this array.
     *
     * @param source            The source collection.
     * @param clearArrayContent True if before copying items the content of this array will be erased, false
     *                          if the new items will be appended to the content of this array.
     * @param numBufferedItems  The number of items to buffer while doing the copy.
     * @return This array.
     */
    Array<T> copyFrom(Collection<T> source, boolean clearArrayContent, long numBufferedItems);


    /**
     * Copy the items of this array into the specified destination list.
     *
     * @param dest             The destination list.
     * @param clearList        True if before copying items the destination list content will be erased, false if
     *                         the array content will be append to the content of the destination list.
     * @param numBufferedItems The number of items to buffer while doing the copy.
     */
    void copyTo(Collection<T> dest, boolean clearList, long numBufferedItems);


    /**
     * Copy the items of this array into the specified destination array.
     *
     * @param dest             The destination array.
     * @param clearArray       True if before copying items the current destination array content will be erased, false if
     *                         the array content will be append to the content of destination array.
     * @param numBufferedItems The number of items to buffer while doing the copy.
     */
    void copyTo(Array<T> dest, boolean clearArray, long numBufferedItems);


    /**
     * Get a representation of this array as an iterator provider.
     *
     * @param numBufferedItems The number of items to buffer while reading data.
     * @return A representation of this array as an immutable data source iterator.
     */
    ImmutableDataSourceIteratorProvider<T> asIteratorProvider(long numBufferedItems);


    /**
     * Get a representation of this array as an iterator provider. Each item
     * returned by iterator is a couple (index, value_at_corresponding_index).
     *
     * @param numBufferedItems The number of items to buffer while reading data.
     * @return A representation of this array as an immutable data source iterator.
     */
    ImmutableDataSourceIteratorProvider<Pair<Long, T>> asIteratorProviderWithIndex(long numBufferedItems);

    /**
     * Enable or disable local cache on the specified range indexes. The cache could NOT
     * be synchronized with the storage so it is responsibility of the programmer to synchronize all
     * modifications of cached data by calling method {@link #flush()}.
     *
     * @param enabled   True to enable cache, false to disable cache (in this case first remember to
     *                  call {@link #flush()} to store cached data modifications).
     * @param fromIndex The included starting index (0-based).
     * @param toIndex   The excluded end index. If the end index is equal to -1 it means to end of the
     *                  array.
     */
    void enableLocalCache(boolean enabled, long fromIndex, long toIndex);

    /**
     * Check if the given array item index is or not cached.
     *
     * @param index The item index to check.
     * @return True if the specified item is cached, false otherwise.
     */
    boolean isLocalCacheEnabled(long index);


    /**
     * Flush cached data to destination storage. After this call, the storage
     * will reflect all changes applied previously in cache. If the array does not use
     * cache then the method will do nothing. The cached data will not be removed from cache:
     * to remove this data from RAM you need to call {@link #enableLocalCache(boolean, long, long)}
     * method.
     */
    void flush();
}
