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
