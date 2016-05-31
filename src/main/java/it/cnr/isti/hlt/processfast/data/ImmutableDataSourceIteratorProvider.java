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

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 * A provider for data source iterators over a finite and immutable data set.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 * @param <T> The type of data provided by data source.
 */
public interface ImmutableDataSourceIteratorProvider<T extends Serializable> {

    /**
     * Get a new iterator over this immutable dataset.
     *
     * @return A new iterator over the wrapped immutable dataset.
     */
    Iterator<T> iterator();


    /**
     * Indicate if the data source provider has valid implementation of {@link #size()} method.
     *
     * @return True if it has a valid implementation, false otherwise.
     */
    boolean sizeEnabled();

    /**
     * Get the number of items stored on this dataset. This operation could be very costly, depending on the
     * specific implementation of the data source provider.
     *
     * @return The number of items stored on this dataset.
     */
    long size();

    /**
     * Indicate if the specified item is contained in the collection. This operation could be very costly, depending on the
     * specific implementation of the data source provider.
     *
     * @param item The item to check.
     * @return
     */
    boolean contains(T item);


    /**
     * Indicate if the data source provider has valid implementation of {@link #contains(Serializable)} method.
     *
     * @return True if it has a valid implementation, false otherwise.
     */
    boolean containsEnabled();


    /**
     * Extract a subset of available items in the data source wrapped by this iterator provider.
     * This operation could be very costly, depending on the
     * specific implementation of the data source provider.
     *
     * @param startFrom The start index of first item to retrieve.
     * @param numItems  The number of items to retrieve.
     * @return The requested subset of items.
     */
    Collection<T> take(long startFrom, long numItems);

    /**
     * Indicate if the data source provider has valid implementation of {@link #take(long, long)} method.
     *
     * @return True if it has a valid implementation, false otherwise.
     */
    boolean takeEnabled();
}
