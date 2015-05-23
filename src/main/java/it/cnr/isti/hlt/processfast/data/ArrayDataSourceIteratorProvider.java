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

    ArrayDataSourceIteratorProvider(Array<T> array, long numBufferedItems) {
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
