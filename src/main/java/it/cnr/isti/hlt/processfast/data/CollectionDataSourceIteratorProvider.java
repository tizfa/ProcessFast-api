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
