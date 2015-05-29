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

import it.cnr.isti.hlt.processfast.utils.Pair;

import java.util.Iterator;

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
