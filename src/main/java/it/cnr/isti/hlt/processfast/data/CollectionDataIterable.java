package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Java collection data iterable.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public class CollectionDataIterable<T extends Serializable> implements DataIterable<T> {

    private Collection<T> collection;

    public CollectionDataIterable(Collection<T> c) {
        if (c == null)
            throw new NullPointerException("The specified collection is 'null'");
        this.collection = c;
    }

    @Override
    public Iterator<T> iterator() {
        return collection.iterator();
    }
}
