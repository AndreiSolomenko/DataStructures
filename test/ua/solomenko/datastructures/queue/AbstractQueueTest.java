package ua.solomenko.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public abstract class AbstractQueueTest {
    private Queue<Object> queue;

    public abstract Queue getQueueImplementation();

    @Before
    public void before() {
        queue = getQueueImplementation();
    }

    @Test
    public void testPushAndPop() {

        //when
        queue.push(1);
        queue.push(2);
        queue.push(3);

        //then
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
    }

    @Test
    public void testPopIfEmpty() {

        //when
        queue.push(null);

        //then
        assertNull(queue.pop());
    }

    @Test
    public void testPopAndPeek() {

        //when
        queue.push(1);
        queue.push(2);
        queue.push(3);

        //then
        assertEquals(1, queue.pop());
        assertEquals(2, queue.peek());
    }
}
