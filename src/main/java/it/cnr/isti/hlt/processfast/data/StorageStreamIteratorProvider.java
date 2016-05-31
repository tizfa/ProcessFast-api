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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * An iterator provider for storage data streams.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class StorageStreamIteratorProvider implements
        ImmutableDataSourceIteratorProvider<Pair<Integer, String>> {


    private final DataStream ds;
    private final String dsName;
    private final String encoding;

    public StorageStreamIteratorProvider(DataStream ds, String dsName, String encoding) {
        if (ds == null)
            throw new NullPointerException("The datastream is 'null'");
        if (dsName == null || dsName.isEmpty())
            throw new IllegalArgumentException("The ds name is 'null' or empty");
        this.ds = ds;
        this.dsName = dsName;
        this.encoding = encoding;
    }


    @Override
    public Iterator<Pair<Integer, String>> iterator() {
        return new StringStreamDataSourceIterator(ds.getInputStreamForResource(dsName), encoding);
    }

    @Override
    public boolean sizeEnabled() {
        return true;
    }

    @Override
    public long size() {
        Iterator<Pair<Integer, String>> it = iterator();
        long count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }

    @Override
    public boolean contains(Pair<Integer, String> item) {
        Iterator<Pair<Integer, String>> it = iterator();
        while (it.hasNext()) {
            if (item.equals(it.next()))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsEnabled() {
        return true;
    }

    @Override
    public Collection<Pair<Integer, String>> take(long startFrom, long numItems) {
        Iterator<Pair<Integer, String>> it = iterator();
        long curIdx = 0;
        ArrayList<Pair<Integer, String>> out = new ArrayList<>();
        while (it.hasNext()) {
            Pair<Integer, String> item = it.next();
            if (curIdx >= startFrom && curIdx < (startFrom + numItems))
                out.add(item);
            curIdx++;
            if (curIdx >= startFrom + numItems)
                break;
        }
        return out;
    }

    @Override
    public boolean takeEnabled() {
        return true;
    }
}
