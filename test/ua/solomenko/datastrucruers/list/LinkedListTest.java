package ua.solomenko.datastrucruers.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LinkedListTest {
    private LinkedList linkedList;

    @Before
    public void before() {
        linkedList = new LinkedList();
        linkedList.add("str1");
        linkedList.add("str2");
        linkedList.add("str3");
    }

    @Test
    public void testAddIntoEmptyList() {
        linkedList.clear();
        assertEquals(linkedList.size(), 0);

        linkedList.add("one");
        assertEquals(linkedList.get(0), "one");
        assertEquals(linkedList.size(), 1);
    }

    @Test
    public void testAddIntoNotEmptyList() {
        linkedList.add("str4");
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(2), "str3");
        assertEquals(linkedList.get(3), "str4");
        assertEquals(linkedList.size(), 4);
    }

    @Test
    public void testAddEnsureCapacity() {
        linkedList.add("str4");
        linkedList.add("str5");
        linkedList.add("str6");
        assertEquals(linkedList.get(5), "str6");
        assertEquals(linkedList.size(), 6);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddIndexInvalidIndex() {
        linkedList.add("str5", 4);
    }

    @Test
    public void testAddIndexEmptyList() {
        linkedList.clear();
        assertEquals(linkedList.size(), 0);
        linkedList.add("begin", 0);
        assertEquals(linkedList.get(0), "begin");
        assertEquals(linkedList.size(), 1);
    }

    @Test
    public void testAddIndexBegin() {
        linkedList.add("begin", 0);
        assertEquals(linkedList.get(0), "begin");
        assertEquals(linkedList.get(1), "str1");
        assertEquals(linkedList.get(2), "str2");
        assertEquals(linkedList.get(3), "str3");
        assertEquals(linkedList.size(), 4);
    }

    @Test
    public void testAddIndexCenter() {
        linkedList.add("center", 1);
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(1), "center");
        assertEquals(linkedList.get(2), "str2");
        assertEquals(linkedList.get(3), "str3");
        assertEquals(linkedList.size(), 4);
    }

    @Test
    public void testAddIndexEnd() {
        linkedList.add("end", 3);
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(1), "str2");
        assertEquals(linkedList.get(2), "str3");
        assertEquals(linkedList.get(3), "end");
        assertEquals(linkedList.size(), 4);
    }

    @Test
    public void testIndexOfNull() {
        linkedList.add(null);
        linkedList.add("str5");
        int actual = linkedList.indexOf(null);
        assertEquals(actual, 3);
    }

    @Test
    public void testIndexOf() {
        int actual = linkedList.indexOf("str2");
        assertEquals(actual, 1);
    }

    @Test
    public void testIndexOfDoesNotExist() {
        int actual = linkedList.indexOf("str50");
        assertEquals(actual, - 1);
    }

    @Test
    public void testLastIndexOfNull() {
        linkedList.add(null);
        linkedList.add(null);
        int actual = linkedList.lastIndexOf(null);
        assertEquals(actual, 4);
    }

    @Test
    public void testLastIndexOf() {
        linkedList.add("str2", 2);
        int actual = linkedList.lastIndexOf("str2");
        assertEquals(actual, 2);
    }

    @Test
    public void testLastIndexOfDoesNotExist() {
        int actual = linkedList.lastIndexOf("str50");
        assertEquals(actual, - 1);
    }

    @Test
    public void testContainsTrue() {
        assertTrue(linkedList.contains("str3"));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(linkedList.contains("str50"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetInvalidIndex() {
        linkedList.set("str4", 3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        linkedList.clear();
        assertEquals(linkedList.size(), 0);
        linkedList.set("setValue", 0);
        assertEquals(linkedList.get(0), "setValue");
        assertEquals(linkedList.size(), 1);
    }

    @Test
    public void testSetBegin() {
        linkedList.set("setValue", 0);
        assertEquals(linkedList.get(0), "setValue");
        assertEquals(linkedList.get(1), "str2");
        assertEquals(linkedList.get(2), "str3");
        assertEquals(linkedList.size(), 3);
    }

    @Test
    public void testSetCenter() {
        linkedList.set("setValue", 1);
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(1), "setValue");
        assertEquals(linkedList.get(2), "str3");
        assertEquals(linkedList.size(), 3);
    }

    @Test
    public void testSetEnd() {
        linkedList.set("setValue", 2);
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(1), "str2");
        assertEquals(linkedList.get(2), "setValue");
        assertEquals(linkedList.size(), 3);
    }

    @Test
    public void testClear() {
        linkedList.clear();
        assertEquals(linkedList.size(), 0);
    }

    @Test
    public void testGetBegin() {
        Object actual = linkedList.get(0);
        assertEquals(actual, "str1");
    }

    @Test
    public void testGetCenter() {
        Object actual = linkedList.get(1);
        assertEquals(actual, "str2");
    }

    @Test
    public void testGetEnd() {
        Object actual = linkedList.get(2);
        assertEquals(actual, "str3");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        linkedList.get(50);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {
        linkedList.clear();
        assertEquals(linkedList.size(), 0);
        linkedList.remove(0);
    }

    @Test
    public void testRemoveBegin() {
        linkedList.remove(0);
        assertEquals(linkedList.get(0), "str2");
        assertEquals(linkedList.get(1), "str3");
        assertEquals(linkedList.size(), 2);
    }

    @Test
    public void testRemoveCenter() {
        linkedList.remove(1);
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(1), "str3");
        assertEquals(linkedList.size(), 2);
    }

    @Test
    public void testRemoveEnd() {
        linkedList.remove(2);
        assertEquals(linkedList.get(0), "str1");
        assertEquals(linkedList.get(1), "str2");
        assertEquals(linkedList.size(), 2);
    }
}