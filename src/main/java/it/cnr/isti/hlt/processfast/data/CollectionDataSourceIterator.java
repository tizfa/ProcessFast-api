/*
 * *****************
 *  Copyright 2015 Tiziano Fagni (tiziano.fagni@isti.cnr.it)
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
 * *******************
 */

package it.cnr.isti.hlt.processfast.data;

import java.io.Serializable;
import java.util.Iterator;

import it.cnr.isti.hlt.processfast.utils.Pair;

/**
 * A data source iterator which iterates over an
 * existing iterator. Each item returned is marked with
 * the index corresponding to the order on which the item
 * on the existing iterator is accessed, with 0 as the first
 * item accessed. 
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 *
 * @param <T> The type of data accessed by existing iterator.
 */
public class CollectionDataSourceIterator<T extends Serializable> implements
        Iterator<Pair<Integer, T>> {
	
	private final Iterator<T> iter;
	private int nextIdx;
	
	public CollectionDataSourceIterator(Iterator<T> iter) {
		this.iter = iter;
		nextIdx = 0;
	}
	

	public boolean hasNext() {
		return iter.hasNext();
	}


	public Pair<Integer, T> next() {
		int curIdx = nextIdx;
		T v = iter.next();
		nextIdx++;
		return new Pair<Integer,T>(curIdx, v);
	}


	public void remove() {
		throw new UnsupportedOperationException();
	}

}
