package ua.solomenko.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayQueueTest extends AbstractQueueTest {

    @Override
    public Queue getQueueImplementation() {
        return new ArrayQueue();
    }

    @Test
    public void testArrayLengthExcessWithMinSize() {
        //prepare
        ArrayQueue<Object> queue = new ArrayQueue();

        //when
        for (int i = 0 ; i < 11 ; i++) {
            queue.push(i);
        }
        for (int i = 0 ; i < 10 ; i++) {
            queue.pop();
        }

        queue.push(11);

        //then
        assertEquals(2, queue.size());
    }

    @Test
    public void testResize() {
        //prepare
        ArrayQueue<Object> queue = new ArrayQueue();

        //when
        for (int i = 0 ; i < 15 ; i++) {
            queue.push(i);
        }

        //then
        assertEquals(15, queue.size());
    }
}