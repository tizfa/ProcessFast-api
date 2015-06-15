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
