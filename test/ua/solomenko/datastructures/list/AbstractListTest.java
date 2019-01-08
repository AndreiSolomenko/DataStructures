package ua.solomenko.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {
    private List<Object> list;

    public abstract List getListImplementation();

    @Before
    public void before() {
        list = getListImplementation();
        list.add("str1");
        list.add("str2");
        list.add("str3");
    }

    @Test
    public void testAddIntoEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);

        list.add("one");
        assertEquals(list.get(0), "one");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testAddIntoNotEmptyList() {
        list.add("str4");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(2), "str3");
        assertEquals(list.get(3), "str4");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testAddEnsureCapacity() {
        list.add("str4");
        list.add("str5");
        list.add("str6");
        assertEquals(list.get(5), "str6");
        assertEquals(list.size(), 6);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddIndexInvalidIndex() {
        list.add("str5", 4);
    }

    @Test
    public void testAddIndexEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.add("begin", 0);
        assertEquals(list.get(0), "begin");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testAddIndexBegin() {
        list.add("begin", 0);
        assertEquals(list.get(0), "begin");
        assertEquals(list.get(1), "str1");
        assertEquals(list.get(2), "str2");
        assertEquals(list.get(3), "str3");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testAddIndexCenter() {
        list.add("center", 1);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "center");
        assertEquals(list.get(2), "str2");
        assertEquals(list.get(3), "str3");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testAddIndexEnd() {
        list.add("end", 3);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.get(3), "end");
        assertEquals(list.size(), 4);
    }

    @Test
    public void testIndexOfNull() {
        list.add(null);
        list.add("str5");
        int actual = list.indexOf(null);
        assertEquals(actual, 3);
    }

    @Test
    public void testIndexOf() {
        int actual = list.indexOf("str2");
        assertEquals(actual, 1);
    }

    @Test
    public void testIndexOfDoesNotExist() {
        int actual = list.indexOf("str50");
        assertEquals(actual, - 1);
    }

    @Test
    public void testLastIndexOfNull() {
        list.add(null);
        list.add(null);
        int actual = list.lastIndexOf(null);
        assertEquals(actual, 4);
    }

    @Test
    public void testLastIndexOf() {
        list.add("str2", 2);
        int actual = list.lastIndexOf("str2");
        assertEquals(actual, 2);
    }

    @Test
    public void testLastIndexOfDoesNotExist() {
        int actual = list.lastIndexOf("str50");
        assertEquals(actual, - 1);
    }

    @Test
    public void testContainsTrue() {
        assertTrue(list.contains("str3"));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(list.contains("str50"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetInvalidIndex() {
        list.set("str4", 3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.set("setValue", 0);
        assertEquals(list.get(0), "setValue");
        assertEquals(list.size(), 1);
    }

    @Test
    public void testSetBegin() {
        list.set("setValue", 0);
        assertEquals(list.get(0), "setValue");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testSetCenter() {
        list.set("setValue", 1);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "setValue");
        assertEquals(list.get(2), "str3");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testSetEnd() {
        list.set("setValue", 2);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "setValue");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testGetBegin() {
        Object actual = list.get(0);
        assertEquals(actual, "str1");
    }

    @Test
    public void testGetCenter() {
        Object actual = list.get(1);
        assertEquals(actual, "str2");
    }

    @Test
    public void testGetEnd() {
        Object actual = list.get(2);
        assertEquals(actual, "str3");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        list.get(50);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.remove(0);
    }

    @Test
    public void testRemoveBegin() {
        list.remove(0);
        assertEquals(list.get(0), "str2");
        assertEquals(list.get(1), "str3");
        assertEquals(list.size(), 2);
    }

    @Test
    public void testRemoveCenter() {
        list.add("str4");
        list.remove(2);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str4");
        assertEquals(list.size(), 3);
    }

    @Test
    public void testRemoveEnd() {
        list.remove(2);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.size(), 2);
    }
}
