package it.cnr.isti.hlt.processfast.connector;

/**
 * A promise representing a value returned by an asynchronous
 * request.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 *
 */
public interface ValuePromise<T> {

    /**
     * Get the value requested with a previous asynchronous request. The
     * caller is eventually suspended until the requested value is available.
     *
     * @return The requested value.
     */
    T get();
}
