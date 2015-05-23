package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.utils.Pair;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public class CollectionDataSourceIteratorProvider<T extends Serializable> implements ImmutableDataSourceIteratorProvider<Pair<Integer, T>> {

    private final Collection<T> collection;

    public CollectionDataSourceIteratorProvider(Collection<T> c) {
        if (c == null)
            throw new NullPointerException("The collection is 'null'");
        this.collection = c;
    }

    public Iterator<Pair<Integer, T>> iterator() {
        return new CollectionDataSourceIterator<T>(collection.iterator());
    }
}
