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
import java.util.List;
import java.util.NoSuchElementException;

/**
 * An Array iterator.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public class ArrayIterator<T extends Serializable> implements Iterator<T> {

    private final Array<T> array;
    private long numBufferedItems;
    private List<T> currentRead;
    private long numTotalItemsRead;
    private int numCurrentItemsRead;
    private long sizeArray;

    public ArrayIterator(Array<T> array, long numBufferedItems) {
        if (array == null)
            throw new NullPointerException("The array is 'null'");
        if (numBufferedItems < 1)
            throw new IllegalArgumentException("The number of buffered items is less than 1");
        this.array = array;
        this.numBufferedItems = numBufferedItems;
        begin();
    }

    void begin() {
        numTotalItemsRead = 0;
        numCurrentItemsRead = 0;
        currentRead = readBuffered(array, 0, numBufferedItems);
        sizeArray = array.size();
    }

    protected List<T> readBuffered(Array<T> array, long fromIndex, long toIndex) {
        if (fromIndex >= toIndex)
            throw new IllegalArgumentException("The fromIndex is >= than toIndex");
        long to = Math.min(toIndex, array.size());
        return array.getValues(fromIndex, to);
    }

    public boolean hasNext() {
        return (numTotalItemsRead + numCurrentItemsRead) < sizeArray;
    }

    public T next() {
        if (!hasNext())
            throw new NoSuchElementException("There are no more items to read.");
        if (numCurrentItemsRead >= currentRead.size()) {
            numTotalItemsRead += currentRead.size();
            numCurrentItemsRead = 0;
            currentRead = readBuffered(array, numTotalItemsRead, numTotalItemsRead+numBufferedItems);
        }

        T item = currentRead.get(numCurrentItemsRead);
        numCurrentItemsRead++;
        return item;
    }

    public void remove() {
        throw new UnsupportedOperationException("The method is not supported");
    }

}
