package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.Iterator;

/**
 * A set of data which is iterable.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public interface DataIterable<T extends Serializable> extends Serializable {

    /**
     * Get an iterator over the set of data.
     *
     * @return An iterator over the set of data.
     */
    Iterator<T> iterator();
}
