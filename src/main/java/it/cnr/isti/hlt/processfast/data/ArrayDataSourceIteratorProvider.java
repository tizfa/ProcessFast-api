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

import java.io.Serializable;
import java.util.Iterator;

/**
 * An iterator provider for an Array.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public class ArrayDataSourceIteratorProvider<T extends Serializable> implements ImmutableDataSourceIteratorProvider<T> {

    private final Array<T> array;

    private final long numBufferedItems;

    public ArrayDataSourceIteratorProvider(Array<T> array, long numBufferedItems) {
        if (array == null)
            throw new NullPointerException("The specified array is 'null'");
        if (numBufferedItems < 1)
            throw new IllegalArgumentException("The number of buffered items is less than 1");
        this.array = array;
        this.numBufferedItems = numBufferedItems;
    }

    public Iterator<T> iterator() {
        return array.asIterator(numBufferedItems);
    }
}
