package it.cnr.isti.hlt.processfast.connector;

import java.util.concurrent.Future;

/**
 * A ValuePromise wrapper for a Future.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class FutureValuePromise<T> implements ValuePromise<T> {

    private final Future<T> future;

    public FutureValuePromise(Future<T> future) {
        if (future == null)
            throw new NullPointerException("The specified future is 'null'");
        this.future = future;
    }

    @Override
    public T get() {
        try {
            return future.get();
        } catch (Exception e) {
            throw new IllegalStateException("Error retrieving value from future", e);
        }
    }
}
