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

import it.cnr.isti.hlt.processfast.utils.Pair;

import java.io.Serializable;
import java.util.*;

/**
 * An iterator provider for an Array whchi returns for each entry the
 * index of item and the item itself.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class ArrayPairDataSourceIteratorProvider<T extends Serializable> implements ImmutableDataSourceIteratorProvider<Pair<Long, T>> {

    private final Array<T> array;

    private final long numBufferedItems;

    public ArrayPairDataSourceIteratorProvider(Array<T> array, long numBufferedItems) {
        if (array == null)
            throw new NullPointerException("The specified array is 'null'");
        if (numBufferedItems < 1)
            throw new IllegalArgumentException("The number of buffered items is less than 1");
        this.array = array;
        this.numBufferedItems = numBufferedItems;
    }

    public Iterator<Pair<Long, T>> iterator() {
        return new ArrayPairIterator<T>(array.asIterator(numBufferedItems));
    }

    @Override
    public boolean sizeEnabled() {
        return true;
    }

    @Override
    public long size() {
        return array.size();
    }

    @Override
    public boolean contains(Pair<Long, T> item) {
        long s = array.size();
        for (long i = 0; i < s; i++) {
            T currentItem = array.getValue(i);
            if (currentItem.equals(item.getV2()) && item.getV1() == i)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsEnabled() {
        return true;
    }

    @Override
    public Collection<Pair<Long, T>> take(long startFrom, long numItems) {
        if (startFrom < 0)
            throw new IllegalArgumentException("The startFrom parameter is < 0");
        if (numItems < 1)
            throw new IllegalArgumentException("The numItems parameter is < 1");
        List<T> values = array.getValues(startFrom, startFrom + numItems);
        ArrayList<Pair<Long, T>> ret = new ArrayList<>();
        for (long i = 0; i < values.size(); i++) {
            ret.add(new Pair<Long, T>(i + startFrom, values.get((int) i)));
        }
        return ret;
    }

    @Override
    public boolean takeEnabled() {
        return true;
    }


    static class ArrayPairIterator<T extends Serializable> implements Iterator<Pair<Long, T>> {

        private final Iterator<T> iter;
        private long index;

        ArrayPairIterator(Iterator<T> iter) {
            this.iter = iter;
            this.index = 0;
        }

        public boolean hasNext() {
            return iter.hasNext();
        }

        public Pair<Long, T> next() {
            if (!iter.hasNext())
                throw new NoSuchElementException("There are no more items to read");
            T item = iter.next();
            return new Pair<Long, T>(index++, item);
        }

        public void remove() {
            throw new UnsupportedOperationException("The method is not supported");
        }
    }
}
