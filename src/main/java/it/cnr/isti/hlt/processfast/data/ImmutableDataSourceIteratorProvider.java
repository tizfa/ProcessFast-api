package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
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
}
