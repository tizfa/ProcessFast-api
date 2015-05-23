package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.utils.Pair;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    ArrayPairDataSourceIteratorProvider(Array<T> array, long numBufferedItems) {
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
