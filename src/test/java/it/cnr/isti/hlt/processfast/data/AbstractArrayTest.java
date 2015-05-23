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
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public abstract class AbstractArrayTest {


    /**
     * Create and initialize an empty array.
     *
     * @param name The name of the array.
     *             @param clearStorageData  True if current storage data must be
     *                                      removed, false otherwise.
     * @return A new array.
     */
    protected abstract Array<Double> initArray(String name, boolean clearStorageData);

    @Test
    public void getNameTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar != null);
        Assert.assertTrue(ar.getName().equals("ar"));
    }


    @Test
    public void sizeTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(1000);
        Assert.assertTrue(ar.size() == 1000);
        ar.resize(5);
        Assert.assertTrue(ar.size() == 5);
        ar.appendValue(1.5);
        Assert.assertTrue(ar.size() == 6);
        ar.appendValue(2.0);
        Assert.assertTrue(ar.size() == 7);
        ar.clear();
        Assert.assertTrue(ar.size() == 0);
    }


    @Test
    public void getValueTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        try {
            ar.getValue(0);
            Assert.fail();
        } catch (Exception e) {
        }
        ar.appendValue(1.5);
        Assert.assertTrue(ar.getValue(0) == 1.5);
        ar.resize(5);
        for (int i = 1; i < 5; i++)
            Assert.assertTrue(ar.getValue(i) == null);
        ar.setValue(4, 10.0);
        Assert.assertTrue(ar.getValue(4) == 10.0);
        Assert.assertTrue(ar.getValue(2) == null);
        ar.setValue(2, 22.0);
        Assert.assertTrue(ar.getValue(2) != null);
        Assert.assertTrue(ar.getValue(2) == 22.0);
        ar.setDefaultValue(100.0);
        Assert.assertTrue(ar.getValue(1) != null);
        Assert.assertTrue(ar.getValue(1) == 100.0);
        Assert.assertTrue(ar.getValue(3) != null);
        Assert.assertTrue(ar.getValue(3) == 100.0);
        ar.resize(2);
        Assert.assertTrue(ar.getValue(0) == 1.5);
        Assert.assertTrue(ar.getValue(1) == 100.0);
        try {
            ar.getValue(2);
            Assert.fail();
        } catch (Exception e) {
        }
        ar.resize(3);
        Assert.assertTrue(ar.getValue(2) == 100.0);

        ar.enableLocalCache(true, 0, 1);
        Assert.assertTrue(ar.getValue(0) == 1.5);
        ar.setValue(0, 1.6);
        Assert.assertTrue(ar.getValue(0) == 1.6);
        ar.enableLocalCache(false, 0, 1);
        Assert.assertTrue(ar.getValue(0) == 1.5);
        ar.enableLocalCache(true, 0, 1);
        Assert.assertTrue(ar.getValue(0) == 1.5);
        ar.setValue(0, 1.6);
        Assert.assertTrue(ar.getValue(0) == 1.6);
        ar.flush();
        ar.enableLocalCache(false, 0, 1);
        Assert.assertTrue(ar.getValue(0) == 1.6);
    }


    @Test
    public void getValuesTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        Assert.assertTrue(ar.size() == 10);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                ar.setValue(i, new Double(i));
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                Assert.assertTrue(ar.getValue(i) == i);
        }
        ar.setDefaultValue(1000.0);
        List<Double> values = ar.getValues(0, 10);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                Assert.assertTrue(values.get(i) == i);
            else
                Assert.assertTrue(values.get(i) == 1000);
        }

        ar.clear();
        ar.resize(10);
        ar.setDefaultValue(2.53);
        values = ar.getValues(0, 10);
        Assert.assertTrue(values != null);
        Assert.assertTrue(values.size() == 10);
        for (double v : values) {
            Assert.assertTrue(v == 2.53);
        }
        ar.setValue(5, 1.0);
        values = ar.getValues(0, 10);
        Assert.assertTrue(values.size() == 10);
        for (int i = 0; i < values.size(); i++) {
            if (i != 5)
                Assert.assertTrue(values.get(i) == 2.53);
            else
                Assert.assertTrue(values.get(i) == 1.0);
        }
    }


    @Test
    public void setValueTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        Assert.assertTrue(ar.getDefaultValue() == null);
        try {
            ar.setValue(0, 10.0);
            Assert.fail();
        } catch (Exception e) {
        }


        ar.resize(5);
        try {
            ar.setValue(5, 10.0);
            Assert.fail();
        } catch (Exception e) {
        }

        ar.setValue(0, 1.0);
        Assert.assertTrue(ar.getValue(0) == 1.0);
        Assert.assertTrue(ar.getValue(1) == null);
        ar.setValue(2, 10.0);
        Assert.assertTrue(ar.getValue(2) == 10.0);
        ar.setValue(2, null);
        Assert.assertTrue(ar.getValue(2) == null);
    }


    @Test
    public void appendValueTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        Assert.assertTrue(ar.getDefaultValue() == null);
        ar.appendValue(2.0);
        Assert.assertTrue(ar.size() == 1);
        Assert.assertTrue(ar.getValue(0) == 2.0);
        ar.appendValue(3.0);
        Assert.assertTrue(ar.size() == 2);
        Assert.assertTrue(ar.getValue(1) == 3.0);

    }


    @Test
    public void getDefaultValueTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        Assert.assertTrue(ar.getDefaultValue() == null);
        ar.appendValue(2.0);
        Assert.assertTrue(ar.size() == 1);
        ar.setDefaultValue(1.11);
        Assert.assertTrue(ar.getDefaultValue() == 1.11);
        ar.resize(10);
        Assert.assertTrue(ar.getValue(9).equals(ar.getDefaultValue()));
    }

    @Test
    public void setDefaultValueTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        Assert.assertTrue(ar.getDefaultValue() == null);
        ar.setDefaultValue(1.11);
        Assert.assertTrue(ar.getDefaultValue() == 1.11);
        ar.resize(10);
        Assert.assertTrue(ar.getValue(9).equals(ar.getDefaultValue()));
        ar.setDefaultValue(2.0);
        Assert.assertTrue(ar.getDefaultValue() == 2.0);
        Assert.assertTrue(ar.getValue(9).equals(ar.getDefaultValue()));
        ar.setDefaultValue(null);
        Assert.assertTrue(ar.getDefaultValue() == null);
        Assert.assertTrue(ar.getValue(9) == ar.getDefaultValue());
    }


    @Test
    public void clearTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        Assert.assertTrue(ar.size() == 10);
        ar.clear();
        Assert.assertTrue(ar.size() == 0);
    }


    @Test
    public void resizeTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        Assert.assertTrue(ar.size() == 10);
        ar.resize(5);
        Assert.assertTrue(ar.size() == 5);
        ar.resize(15);
        Assert.assertTrue(ar.size() == 15);
        ar.clear();
        ar.resize(5);
        ar.setDefaultValue(10.0);
        for (int i = 0; i < 5; i++)
            ar.setValue(i, new Double(i));
        ar.resize(10);
        for (int i = 0; i < 5; i++)
            Assert.assertTrue(ar.getValue(i) == i);
        for (int i = 5; i < 10; i++) {
            Assert.assertTrue(ar.getValue(i).equals(ar.getDefaultValue()));
        }
    }


    @Test
    public void asIteratorTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        for (int i = 0; i < 10; i++)
            ar.setValue(i, new Double(i*2));

        try {
            ar.asIterator(0);
            Assert.fail();
        } catch (Exception e) {}

        try {
            ar.asIterator(-1);
            Assert.fail();
        } catch (Exception e) {}

        Iterator<Double> iter = ar.asIterator(20);
        Assert.assertTrue(iter.hasNext());
        int idx = 0;
        while (iter.hasNext()) {
            double v = iter.next();
            Assert.assertTrue(v == new Double(idx*2));
            idx++;
        }
        Assert.assertTrue(idx == 10);
        try {
            iter.next();
            Assert.fail();
        } catch (Exception e) {}

        iter = ar.asIterator(10);
        Assert.assertTrue(iter.hasNext());
        idx = 0;
        while (iter.hasNext()) {
            double v = iter.next();
            Assert.assertTrue(v == new Double(idx*2));
            idx++;
        }
        Assert.assertTrue(idx == 10);

        iter = ar.asIterator(3);
        Assert.assertTrue(iter.hasNext());
        idx = 0;
        while (iter.hasNext()) {
            double v = iter.next();
            Assert.assertTrue(v == new Double(idx*2));
            idx++;
        }
        Assert.assertTrue(idx == 10);
    }


    @Test
    public void copyFromArrayTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        for (int i = 0; i < 10; i++)
            ar.setValue(i, new Double(i*2));
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(ar.getValue(i).equals(new Double(i * 2)));
        }

        Array<Double> ar2 = initArray("ar2", false);
        for (int i = 0; i < 10; i++)
            Assert.assertTrue(ar.getValue(i).equals(new Double(i*2)));
        Assert.assertTrue(ar2.size() == 0);
        ar2.copyFrom(ar, true, 20);
        Assert.assertTrue(ar2.size() == 10);
        for (int i = 0; i < 10; i++)
            Assert.assertTrue(ar2.getValue(i).equals(new Double(i*2)));
    }


    @Test
    public void copyFromCollectionTest() {
        ArrayList<Double> ar = new ArrayList<Double>();
        for (int i = 0; i < 10; i++)
            ar.add(i, new Double(i * 2));

        Array<Double> ar2 = initArray("ar2", true);
        Assert.assertTrue(ar2.size() == 0);
        ar2.copyFrom(ar, true, 20);
        Assert.assertTrue(ar2.size() == 10);
        for (int i = 0; i < 10; i++)
            Assert.assertTrue(ar2.getValue(i).equals(new Double(i * 2)));

        ar2.copyFrom(ar, true, 3);
        Assert.assertTrue(ar2.size() == 10);
        for (int i = 0; i < 10; i++)
            Assert.assertTrue(ar2.getValue(i).equals(new Double(i * 2)));

        ar2.copyFrom(ar, false, 3);
        Assert.assertTrue(ar2.size() == 20);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(ar2.getValue(i) != null);
            Assert.assertTrue(ar2.getValue(i).equals(new Double(i * 2)));
        }
        for (int i = 10; i < 20; i++) {
            Assert.assertTrue(ar2.getValue(i) != null);
            Assert.assertTrue(ar2.getValue(i).equals(new Double((i - 10) * 2)));
        }
    }


    @Test
    public void copyToArrayTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        for (int i = 0; i < 10; i++)
            ar.setValue(i, new Double(i*2));
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(ar.getValue(i).equals(new Double(i * 2)));
        }

        Array<Double> ar2 = initArray("ar2", false);
        Assert.assertTrue(ar2.size() == 0);
        ar.copyTo(ar2, true, 20);
        Assert.assertTrue(ar2.size() == 10);
        for (int i = 0; i < 10; i++)
            Assert.assertTrue(ar2.getValue(i).equals(new Double(i*2)));
    }

    @Test
    public void copyToCollectionTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        ar.resize(10);
        for (int i = 0; i < 10; i++)
            ar.setValue(i, new Double(i*2));
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(ar.getValue(i).equals(new Double(i * 2)));
        }

        ArrayList<Double> ar2 = new ArrayList<Double>();
        Assert.assertTrue(ar2.size() == 0);
        ar.copyTo(ar2, true, 20);
        Assert.assertTrue(ar2.size() == 10);
        for (int i = 0; i < 10; i++)
            Assert.assertTrue(ar2.get(i).equals(new Double(i*2)));
    }


    @Test
    public void asIteratorProviderTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        Assert.assertTrue(ar.asIteratorProvider(2) != null);
        Iterator<Double> it = ar.asIteratorProvider(2).iterator();
        Assert.assertTrue(it != null);
        Assert.assertTrue(!it.hasNext());
        ar.resize(10);
        for (int i = 0; i < 10; i++)
            ar.setValue(i, new Double(i*2));
        it = ar.asIteratorProvider(2).iterator();
        Assert.assertTrue(it != null);
        Assert.assertTrue(it.hasNext());
        int i = 0;
        while(it.hasNext()) {
            Double d = it.next();
            Assert.assertTrue(d.equals(new Double(i*2)));
            i++;
        }
        it = ar.asIteratorProvider(2).iterator();
        Iterator<Double> it2 = ar.asIteratorProvider(2).iterator();
        it.next(); it.next();
        Assert.assertTrue(it.next().equals(new Double(2 * 2)));
        it2.next();
        Assert.assertTrue(it2.next().equals(new Double(2)));
    }


    @Test
    public void asIteratorProviderWithIndexTest() {
        Array<Double> ar = initArray("ar", true);
        Assert.assertTrue(ar.size() == 0);
        Assert.assertTrue(ar.asIteratorProviderWithIndex(2) != null);
        Iterator<Pair<Long, Double>> it = ar.asIteratorProviderWithIndex(2).iterator();
        Assert.assertTrue(it != null);
        Assert.assertTrue(!it.hasNext());
        ar.resize(10);
        for (int i = 0; i < 10; i++)
            ar.setValue(i, new Double(i*2));
        it = ar.asIteratorProviderWithIndex(2).iterator();
        Assert.assertTrue(it != null);
        Assert.assertTrue(it.hasNext());
        int i = 0;
        while(it.hasNext()) {
            Pair<Long, Double> val = it.next();
            Assert.assertTrue(val.getV1().equals((long)i));
            Assert.assertTrue(val.getV2().equals(new Double(i*2)));
            i++;
        }
    }
}
