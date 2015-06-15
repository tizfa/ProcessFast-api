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
import java.util.Iterator;

/**
 * An immutable iterator over the lines contained in a text stream. Each
 * line is returned along with the corresponding order index as found
 * while reading the stream.
 * 
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
public class StringStreamDataSourceIterator implements
        Iterator<Pair<Integer, String>> {

	private BufferedReader reader;
	String nextLine;
	int nextLineIdx;

	/**
	 * Build new instance of the iterator.
	 * 
	 * @param is
	 *            The input stream where to iterate.
	 */
	public StringStreamDataSourceIterator(InputStream is, String encoding) {
		if (is == null)
			throw new NullPointerException("The input stream is 'null'");
		try {
			this.reader = new BufferedReader(
					new InputStreamReader(is, encoding));
			nextLine = reader.readLine();
			nextLineIdx = 1;
		} catch (Exception e) {
			throw new RuntimeException("Error iterating over text stream", e);
		}
	}

	public boolean hasNext() {
		return nextLine != null;
	}

	public Pair<Integer, String> next() {
		String currentLine = nextLine;
		int curIdx = nextLineIdx;
		try {
			nextLine = reader.readLine();
			nextLineIdx++;
		} catch (IOException e) {
			throw new RuntimeException("Reading next line", e);
		}
		return new Pair<Integer, String>(curIdx, currentLine);
	}

	public void remove() {
		throw new UnsupportedOperationException("The method is not supported");
	}
}
