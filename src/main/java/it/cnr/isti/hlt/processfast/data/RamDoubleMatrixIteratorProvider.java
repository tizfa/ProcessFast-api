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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public class RamDoubleMatrixIteratorProvider implements ImmutableDataSourceIteratorProvider<Pair<Integer, double[]>> {

    final private double[][] matrix;
    final private boolean rowIterator;

    public RamDoubleMatrixIteratorProvider(double[][] matrix, boolean rowIterator) {
        if (matrix == null)
            throw new NullPointerException("The matrix is 'null'");
        this.matrix = matrix;
        this.rowIterator = rowIterator;
    }

        public Iterator<Pair<Integer, double[]>> iterator() {
        return new RamMatrixIterator(matrix, rowIterator);
        }

    @Override
    public boolean sizeEnabled() {
        return true;
    }

    @Override
    public long size() {
        if (rowIterator) {
            return matrix.length;
        } else {
            return matrix[0].length;
        }
    }

    @Override
    public boolean contains(Pair<Integer, double[]> item) {
        return false;
    }

    @Override
    public boolean containsEnabled() {
        return false;
    }

    @Override
    public Collection<Pair<Integer, double[]>> take(long startFrom, long numItems) {
        if (startFrom < 0)
            throw new IllegalArgumentException("The startFrom parameter is < 0");
        if (numItems < 1)
            throw new IllegalArgumentException("The numItems parameter is < 1");
        if (startFrom >= size())
            throw new IllegalArgumentException("The startFrom parameter is >= size()");
        long to = startFrom + numItems - 1;
        if (to >= size())
            to = size() - 1;

        List<Pair<Integer, double[]>> coll = new ArrayList<>();
        if (rowIterator) {
            for (int i = (int) startFrom; i <= to; i++) {
                coll.add(new Pair<Integer, double[]>(i, matrix[i]));
            }
        } else {
            for (int i = (int) startFrom; i <= to; i++) {
                double[] col = new double[matrix.length];
                for (int colIdx = 0; colIdx < col.length; colIdx++)
                    col[colIdx] = matrix[colIdx][i];
                coll.add(new Pair<Integer, double[]>(i, col));
            }
        }
        return coll;
    }

    @Override
    public boolean takeEnabled() {
        return true;
    }


    public class RamMatrixIterator implements Iterator<Pair<Integer, double[]>>{

        final private double[][] matrix;
        final private boolean rowIterator;
        private int curIdx;

        public RamMatrixIterator(double[][] matrix, boolean rowIterator) {
            if (matrix == null)
                throw new NullPointerException("The matrix is 'null'");
            this.matrix = matrix;
            this.rowIterator = rowIterator;
            this.curIdx = 0;
        }

        public boolean hasNext() {
            if (rowIterator) {
                return curIdx < matrix.length;
            } else {
                return curIdx < matrix[0].length;
            }
        }


        public Pair<Integer, double[]> next() {
            if (!hasNext())
                return null;
            if (rowIterator) {
                Pair<Integer, double[]> ret =  new Pair<Integer, double[]>(curIdx, matrix[curIdx]);
                curIdx++;
                return ret;
            } else {
                double[] ret = new double[matrix.length];
                for (int i = 0; i < matrix.length; i++) {
                    ret[i] = matrix[i][curIdx];
                }
                Pair<Integer, double[]> toRet = new Pair<Integer, double[]>(curIdx, ret);
                curIdx++;
                return toRet;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("The method is not supported");
        }
    }
}
