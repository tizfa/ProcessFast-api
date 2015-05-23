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

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public abstract class AbstractStorageTest {


    /**
     * Create and initialize an empty storage.
     *
     * @return A storage to be used in tests.
     */
    protected abstract Storage initStorage(String storageName);

    @Test
    public void getNameTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getName().equals("test"));
    }

    @Test
    public void getArrayNamesTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getArrayNames().size() == 0);
        storage.createArray("testArray", Integer.class);
        Assert.assertTrue(storage.getArrayNames().size() == 1);
        storage.createArray("testArray2", Integer.class);
        Assert.assertTrue(storage.getArrayNames().size() == 2);
        storage.removeArray("testArray");
        Assert.assertTrue(storage.getArrayNames().size() == 1);
        storage.removeArray("testArray2");
        Assert.assertTrue(storage.getArrayNames().size() == 0);
    }

    @Test
    public void containsArrayNameTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getArrayNames().size() == 0);
        try {
            Assert.assertTrue(!storage.containsArrayName(null));
            Assert.fail();
        } catch (Exception e) {}
        try {
            Assert.assertTrue(!storage.containsArrayName(""));
            Assert.fail();
        } catch (Exception e) {}
        Assert.assertTrue(!storage.containsArrayName("unstored"));
        storage.createArray("testArray", Integer.class);
        Assert.assertTrue(storage.containsArrayName("testArray"));
        storage.createArray("testArray2", Integer.class);
        Assert.assertTrue(storage.containsArrayName("testArray2"));
        storage.removeArray("testArray");
        Assert.assertTrue(!storage.containsArrayName("testArray"));
        storage.removeArray("testArray2");
        Assert.assertTrue(!storage.containsArrayName("testArray2"));
    }

    @Test
    public void createArrayTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getArrayNames().size() == 0);
        try {
            storage.createArray(null, Integer.class);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.createArray("testArray", null);
            Assert.fail();
        } catch (Exception e) {
        }


        Array<Integer> ar = storage.createArray("testArray", Integer.class);
        Assert.assertTrue(ar != null);
        Assert.assertTrue(storage.containsArrayName("testArray"));
        Assert.assertTrue(storage.getArrayNames().size() == 1);
        ar = storage.createArray("testArray2", Integer.class);
        Assert.assertTrue(ar != null);
        Assert.assertTrue(storage.containsArrayName("testArray2"));
        Assert.assertTrue(storage.getArrayNames().size() == 2);
    }


    @Test
    public void removeArrayTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getArrayNames().size() == 0);
        try {
            storage.removeArray(null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.removeArray("test");
        } catch (Exception e) {
            Assert.fail();
        }

        storage.createArray("testArray", Integer.class);
        storage.createArray("testArray2", Integer.class);
        Assert.assertTrue(storage.containsArrayName("testArray"));
        Assert.assertTrue(storage.getArrayNames().size() == 2);
        storage.removeArray("testArray");
        Assert.assertTrue(!storage.containsArrayName("testArray"));
        Assert.assertTrue(storage.getArrayNames().size() == 1);
        storage.removeArray("testArray2");
        Assert.assertTrue(!storage.containsArrayName("testArray2"));
        Assert.assertTrue(storage.getArrayNames().size() == 0);
    }


    @Test
    public void getArrayTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getArrayNames().size() == 0);
        try {
            storage.getArray(null, Integer.class);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            Assert.assertTrue(storage.getArray("", Integer.class) == null);
            Assert.fail();
        } catch (Exception e){}
        try {
            Assert.assertTrue(storage.getArray("unstored", null) == null);
            Assert.fail();
        } catch (Exception e){}

        Assert.assertTrue(storage.getArray("unstored", Integer.class) == null);

        storage.createArray("testArray", Integer.class);
        storage.createArray("testArray2", Integer.class);
        Assert.assertTrue(storage.containsArrayName("testArray"));
        Assert.assertTrue(storage.getArrayNames().size() == 2);


        Array<Integer> ar = storage.getArray("testArray", Integer.class);
        Assert.assertTrue(ar != null);
        ar = storage.getArray("testArray2", Integer.class);
        Assert.assertTrue(ar != null);

        storage.removeArray("testArray");
        ar = storage.getArray("testArray", Integer.class);
        Assert.assertTrue(ar == null);
        storage.removeArray("testArray2");
        ar = storage.getArray("testArray2", Integer.class);
        Assert.assertTrue(ar == null);

    }


    ////////////////////////////////// Matrix /////////////////////////////////

    @Test
    public void getMatrixNamesTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
        storage.createMatrix("matrix", Double.class, 10, 10);
        Assert.assertTrue(storage.getMatrixNames().size() == 1);
        storage.createMatrix("matrix2", Double.class, 10, 10);
        Assert.assertTrue(storage.getMatrixNames().size() == 2);
        storage.removeMatrix("matrix");
        Assert.assertTrue(storage.getMatrixNames().size() == 1);
        storage.removeMatrix("matrix2");
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
    }

    @Test
    public void containsMatrixNameTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
        try {
            Assert.assertTrue(!storage.containsMatrixName(null));
            Assert.fail();
        } catch (Exception e){}

        try {
            Assert.assertTrue(!storage.containsMatrixName(""));
            Assert.fail();
        } catch (Exception e){}
        Assert.assertTrue(!storage.containsMatrixName("unstored"));
        storage.createMatrix("matrix", Double.class, 10, 10);
        Assert.assertTrue(storage.containsMatrixName("matrix"));
        storage.createMatrix("matrix2", Double.class, 10, 10);
        Assert.assertTrue(storage.containsMatrixName("matrix2"));
        storage.removeMatrix("matrix");
        Assert.assertTrue(!storage.containsMatrixName("matrix"));
        storage.removeMatrix("matrix2");
        Assert.assertTrue(!storage.containsMatrixName("matrix2"));
    }

    @Test
    public void createMatrixTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
        try {
            storage.createMatrix(null, Integer.class, 10, 10);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.createMatrix("matrix", null, 10, 10);
            Assert.fail();
        } catch (Exception e) {
        }


        Matrix<Integer> m = storage.createMatrix("matrix", Integer.class, 10, 10);
        Assert.assertTrue(m != null);
        Assert.assertTrue(storage.containsMatrixName("matrix"));
        Assert.assertTrue(storage.getMatrixNames().size() == 1);
        m = storage.createMatrix("matrix2", Integer.class, 10, 10);
        Assert.assertTrue(m != null);
        Assert.assertTrue(storage.containsMatrixName("matrix2"));
        Assert.assertTrue(storage.getMatrixNames().size() == 2);
    }


    @Test
    public void removeMatrixTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
        try {
            storage.removeMatrix(null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.removeMatrix("test");
        } catch (Exception e) {
            Assert.fail();
        }

        storage.createMatrix("matrix", Integer.class, 10, 10);
        storage.createMatrix("matrix2", Integer.class, 10, 10);
        Assert.assertTrue(storage.containsMatrixName("matrix"));
        Assert.assertTrue(storage.getMatrixNames().size() == 2);
        storage.removeMatrix("matrix");
        Assert.assertTrue(!storage.containsMatrixName("matrix"));
        Assert.assertTrue(storage.getMatrixNames().size() == 1);
        storage.removeMatrix("matrix2");
        Assert.assertTrue(!storage.containsMatrixName("matrix2"));
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
    }


    @Test
    public void getMatrixTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getMatrixNames().size() == 0);
        try {
            storage.getMatrix(null, Integer.class);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.getMatrix("test", null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            Assert.assertTrue(storage.getMatrix("", Integer.class) == null);
            Assert.fail();
        } catch (Exception e){}
        Assert.assertTrue(storage.getMatrix("unstored", Double.class) == null);

        storage.createMatrix("matrix", Integer.class, 10, 10);
        storage.createMatrix("matrix2", Integer.class, 10, 10);
        Assert.assertTrue(storage.containsMatrixName("matrix"));
        Assert.assertTrue(storage.getMatrixNames().size() == 2);


        Matrix<Integer> ar = storage.getMatrix("matrix", Integer.class);
        Assert.assertTrue(ar != null);
        ar = storage.getMatrix("matrix2", Integer.class);
        Assert.assertTrue(ar != null);

        storage.removeMatrix("matrix");
        ar = storage.getMatrix("matrix", Integer.class);
        Assert.assertTrue(ar == null);
        storage.removeMatrix("matrix2");
        ar = storage.getMatrix("testArray2", Integer.class);
        Assert.assertTrue(ar == null);
    }


    ////////////////////////////////////////  DICTIONARY ///////////////////////////////////////////////////

    @Test
    public void getDictionaryNamesTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
        storage.createDictionary("testDictionary");
        Assert.assertTrue(storage.getDictionaryNames().size() == 1);
        storage.createDictionary("testDictionary2");
        Assert.assertTrue(storage.getDictionaryNames().size() == 2);
        storage.removeDictionary("testDictionary");
        Assert.assertTrue(storage.getDictionaryNames().size() == 1);
        storage.removeDictionary("testDictionary2");
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
    }

    @Test
    public void containsDictionaryNameTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
        try {
            Assert.assertTrue(!storage.containsDictionaryName(null));
            Assert.fail();
        } catch (Exception e) {}
        try {
            Assert.assertTrue(!storage.containsDictionaryName(""));
            Assert.fail();
        } catch (Exception e) {}
        Assert.assertTrue(!storage.containsDictionaryName("unstored"));
        storage.createDictionary("testDictionary");
        Assert.assertTrue(storage.containsDictionaryName("testDictionary"));
        storage.createDictionary("testDictionary2");
        Assert.assertTrue(storage.containsDictionaryName("testDictionary2"));
        storage.removeDictionary("testDictionary");
        Assert.assertTrue(!storage.containsDictionaryName("testDictionary"));
        storage.removeDictionary("testDictionary2");
        Assert.assertTrue(!storage.containsDictionaryName("testDictionary2"));
    }

    @Test
    public void createDictionaryTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
        try {
            storage.createDictionary(null);
            Assert.fail();
        } catch (Exception e) {
        }


        Dictionary d = storage.createDictionary("testDictionary");
        Assert.assertTrue(d != null);
        Assert.assertTrue(storage.containsDictionaryName("testDictionary"));
        Assert.assertTrue(storage.getDictionaryNames().size() == 1);
        d = storage.createDictionary("testDictionary2");
        Assert.assertTrue(d != null);
        Assert.assertTrue(storage.containsDictionaryName("testDictionary2"));
        Assert.assertTrue(storage.getDictionaryNames().size() == 2);
    }


    @Test
    public void removeDictionaryTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
        try {
            storage.removeDictionary(null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.removeDictionary("test");
        } catch (Exception e) {
            Assert.fail();
        }

        storage.createDictionary("testDictionary");
        storage.createDictionary("testDictionary2");
        Assert.assertTrue(storage.containsDictionaryName("testDictionary"));
        Assert.assertTrue(storage.getDictionaryNames().size() == 2);
        storage.removeDictionary("testDictionary");
        Assert.assertTrue(!storage.containsDictionaryName("testDictionary"));
        Assert.assertTrue(storage.getDictionaryNames().size() == 1);
        storage.removeDictionary("testDictionary2");
        Assert.assertTrue(!storage.containsDictionaryName("testDictionary2"));
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
    }


    @Test
    public void getDictionaryTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDictionaryNames().size() == 0);
        try {
            storage.getDictionary(null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            Assert.assertTrue(storage.getDictionary("") == null);
            Assert.fail();
        } catch (Exception e){}
        Assert.assertTrue(storage.getDictionary("unstored") == null);

        storage.createDictionary("testDictionary");
        storage.createDictionary("testDictionary2");
        Assert.assertTrue(storage.containsDictionaryName("testDictionary"));
        Assert.assertTrue(storage.getDictionaryNames().size() == 2);


        Dictionary d = storage.getDictionary("testDictionary");
        Assert.assertTrue(d != null);
        d = storage.getDictionary("testDictionary2");
        Assert.assertTrue(d != null);

        storage.removeDictionary("testDictionary");
        d = storage.getDictionary("testDictionary");
        Assert.assertTrue(d == null);
        storage.removeDictionary("testDictionary2");
        d = storage.getDictionary("testDictionary2");
        Assert.assertTrue(d == null);

    }


    ////////////////////////////////// DATA STREAM   ///////////////////////////////////////////

    @Test
    public void getDataStreamNamesTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
        storage.createDataStream("testDataStream");
        Assert.assertTrue(storage.getDataStreamNames().size() == 1);
        storage.createDataStream("testDataStream2");
        Assert.assertTrue(storage.getDataStreamNames().size() == 2);
        storage.removeDataStream("testDataStream");
        Assert.assertTrue(storage.getDataStreamNames().size() == 1);
        storage.removeDataStream("testDataStream2");
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
    }

    @Test
    public void containsDataStreamNameTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
        try {
            Assert.assertTrue(!storage.containsDataStreamName(null));
            Assert.fail();
        }catch (Exception e){}
        try {
            Assert.assertTrue(!storage.containsDataStreamName(""));
            Assert.fail();
        } catch (Exception e){}
        Assert.assertTrue(!storage.containsDataStreamName("unstored"));
        storage.createDataStream("testDataStream");
        Assert.assertTrue(storage.containsDataStreamName("testDataStream"));
        storage.createDataStream("testDataStream2");
        Assert.assertTrue(storage.containsDataStreamName("testDataStream2"));
        storage.removeDataStream("testDataStream");
        Assert.assertTrue(!storage.containsDataStreamName("testDataStream"));
        storage.removeDataStream("testDataStream2");
        Assert.assertTrue(!storage.containsDataStreamName("testDataStream2"));
    }

    @Test
    public void createDataStreamTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
        try {
            storage.createDataStream(null);
            Assert.fail();
        } catch (Exception e) {
        }


        DataStream d = storage.createDataStream("testDataStream");
        Assert.assertTrue(d != null);
        Assert.assertTrue(storage.containsDataStreamName("testDataStream"));
        Assert.assertTrue(storage.getDataStreamNames().size() == 1);
        d = storage.createDataStream("testDataStream2");
        Assert.assertTrue(d != null);
        Assert.assertTrue(storage.containsDataStreamName("testDataStream2"));
        Assert.assertTrue(storage.getDataStreamNames().size() == 2);
    }


    @Test
    public void removeDataStreamTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
        try {
            storage.removeDataStream(null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            storage.removeDataStream("test");
        } catch (Exception e) {
            Assert.fail();
        }

        storage.createDataStream("testDataStream");
        storage.createDataStream("testDataStream2");
        Assert.assertTrue(storage.containsDataStreamName("testDataStream"));
        Assert.assertTrue(storage.getDataStreamNames().size() == 2);
        storage.removeDataStream("testDataStream");
        Assert.assertTrue(!storage.containsDataStreamName("testDataStream"));
        Assert.assertTrue(storage.getDataStreamNames().size() == 1);
        storage.removeDataStream("testDataStream2");
        Assert.assertTrue(!storage.containsDataStreamName("testDataStream2"));
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
    }


    @Test
    public void getDataStreamTest() {
        Storage storage = initStorage("test");
        Assert.assertTrue(storage.getDataStreamNames().size() == 0);
        try {
            storage.getDataStream(null);
            Assert.fail();
        } catch (Exception e) {
        }

        try {
            Assert.assertTrue(storage.getDataStream("") == null);
            Assert.fail();
        }catch (Exception e){}
        Assert.assertTrue(storage.getDataStream("unstored") == null);

        storage.createDataStream("testDataStream");
        storage.createDataStream("testDataStream2");
        Assert.assertTrue(storage.containsDataStreamName("testDataStream"));
        Assert.assertTrue(storage.getDataStreamNames().size() == 2);


        DataStream d = storage.getDataStream("testDataStream");
        Assert.assertTrue(d != null);
        d = storage.getDataStream("testDataStream2");
        Assert.assertTrue(d != null);

        storage.removeDataStream("testDataStream");
        d = storage.getDataStream("testDataStream");
        Assert.assertTrue(d == null);
        storage.removeDataStream("testDataStream2");
        d = storage.getDataStream("testDataStream2");
        Assert.assertTrue(d == null);
    }
}
