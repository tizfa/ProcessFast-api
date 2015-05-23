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
                if (curIdx < matrix.length)
                    return true;
                else
                    return false;
            } else {
                if (curIdx < matrix[0].length)
                    return true;
                else
                    return false;
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
