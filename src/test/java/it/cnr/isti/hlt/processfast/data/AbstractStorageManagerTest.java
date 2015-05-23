package it.cnr.isti.hlt.processfast.data;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
public abstract class AbstractStorageManagerTest {


    /**
     * Create and initialize an empty storage manager.
     *
     * @return A storage manager.
     */
    protected abstract StorageManager initStorageManager();

    @Test
    public void createStorageTest() {
        StorageManager sm = initStorageManager();
        Assert.assertTrue(sm.getStorageNames().size() == 0);
        Assert.assertTrue(sm.getStorage("test") == null);
        try {
            sm.createStorage(null);
            Assert.fail();
        } catch (Exception e) {
        }


        try {
            sm.createStorage("");
            Assert.fail();
        } catch (Exception e) {
        }

        Storage storage = sm.createStorage("test");
        Assert.assertTrue(sm.getStorage("test") != null);
        Assert.assertNotNull(storage);
        Assert.assertTrue(storage.getName().equals("test"));
        Assert.assertTrue(sm.getStorageNames().size() == 1);
        Assert.assertTrue(sm.getStorageNames().get(0).equals("test"));
        Assert.assertTrue(sm.getStorage("test") != null);
    }



    @Test
    public void getStorageNamesTest() {
        StorageManager sm = initStorageManager();
        Assert.assertTrue(sm.getStorageNames().size() == 0);
        sm.createStorage("test1");
        Assert.assertTrue(sm.getStorageNames().size() == 1);
        Assert.assertTrue(sm.getStorageNames().get(0).equals("test1"));
        sm.createStorage("test1");
        Assert.assertTrue(sm.getStorageNames().size() == 1);
        sm.createStorage("test2");
        sm.createStorage("test3");
        Assert.assertTrue(sm.getStorageNames().size() == 3);
        Assert.assertTrue(sm.getStorageNames().get(1).equals("test2"));
        Assert.assertTrue(sm.getStorageNames().get(2).equals("test3"));
    }

    @Test
    public void containsStorageNameTest() {
        StorageManager sm = initStorageManager();
        Assert.assertTrue(!sm.containsStorageName("test1"));
        sm.createStorage("test1");
        Assert.assertTrue(sm.containsStorageName("test1"));
        sm.createStorage("test1");
        Assert.assertTrue(sm.containsStorageName("test1"));
        sm.createStorage("test2");
        sm.createStorage("test3");
        Assert.assertTrue(sm.containsStorageName("test2"));
        Assert.assertTrue(sm.containsStorageName("test3"));
        Assert.assertTrue(!sm.containsStorageName("test4"));
        sm.removeStorage("test3");
        Assert.assertTrue(!sm.containsStorageName("test3"));
    }


    @Test
    public void removeStorageTest() {
        StorageManager sm = initStorageManager();
        Assert.assertTrue(sm.getStorageNames().size() == 0);
        sm.removeStorage("test1");
        sm.createStorage("test1");
        Assert.assertTrue(sm.getStorageNames().size() == 1);
        sm.removeStorage("test1");
        Assert.assertTrue(sm.getStorageNames().size() == 0);
        sm.createStorage("test2");
        sm.createStorage("test3");
        Assert.assertTrue(sm.getStorageNames().size() == 2);
        sm.removeStorage("test2");
        Assert.assertTrue(sm.getStorageNames().size() == 1);
        sm.removeStorage("test3");
        Assert.assertTrue(sm.getStorageNames().size() == 0);
    }

    @Test
    public void getStorageTest() {
        StorageManager sm = initStorageManager();
        Assert.assertTrue(sm.getStorageNames().size() == 0);
        Assert.assertTrue(sm.getStorage("test1") == null);
        sm.createStorage("test1");
        Assert.assertTrue(sm.getStorage("test1") != null);
        Assert.assertTrue(sm.getStorage("test1").getName().equals("test1"));
        sm.createStorage("test2");
        sm.createStorage("test3");
        Assert.assertTrue(sm.getStorage("test2") != null);
        Assert.assertTrue(sm.getStorage("test2").getName().equals("test2"));
        Assert.assertTrue(sm.getStorage("test3") != null);
        Assert.assertTrue(sm.getStorage("test3").getName().equals("test3"));
        sm.removeStorage("test2");
        Assert.assertTrue(sm.getStorage("test2") == null);
        sm.removeStorage("test3");
        Assert.assertTrue(sm.getStorage("test3") == null);
    }


    @Test
    public void clearTest() {
        StorageManager sm = initStorageManager();
        Assert.assertTrue(sm.getStorageNames().size() == 0);
        sm.clear();
        sm.createStorage("test1");
        sm.createStorage("test2");
        sm.createStorage("test3");
        Assert.assertTrue(sm.getStorageNames().size() == 3);
        sm.clear();
        Assert.assertTrue(sm.getStorageNames().size() == 0);
    }
}
