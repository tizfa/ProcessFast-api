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
import sun.swing.BakedArrayList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public boolean sizeEnabled() {
        return true;
    }

    @Override
    public long size() {
        return collection.size();
    }

    @Override
    public boolean contains(Pair<Integer, T> item) {
        return collection.contains(item);
    }

    @Override
    public boolean containsEnabled() {
        return true;
    }

    @Override
    public Collection<Pair<Integer, T>> take(long startFrom, long numItems) {
        if (startFrom < 0)
            throw new IllegalArgumentException("The startFrom parameter is < 0");
        if (numItems < 1)
            throw new IllegalArgumentException("The numItems parameter is < 1");
        if (startFrom >= collection.size())
            throw new IllegalArgumentException("The startFrom parameter >= size()");
        ArrayList<Pair<Integer, T>> coll = new ArrayList();
        long to = startFrom + numItems;
        if (to >= size())
            to = size() - 1;

        List<T> res = collection.parallelStream().skip(startFrom).limit(numItems).collect(Collectors.toList());
        ArrayList<Pair<Integer, T>> ret = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            ret.add(new Pair<Integer, T>((int) (i + startFrom), res.get((i))));
        }
        return ret;
    }

    @Override
    public boolean takeEnabled() {
        return true;
    }
}
