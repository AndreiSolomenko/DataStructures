package ua.solomenko.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayQueueTest{

    @Test
    public void testPushPeekAndPop(){
        //prepare
        ArrayQueue queue = new ArrayQueue();

        //when
        for(int i = 0 ; i < 11 ; i++){
            queue.push(i);
        }
        //then
        assertEquals(11, queue.size());

        for(int i = 0 ; i < 11 ; i++){
            assertEquals(i, queue.peek());
            assertEquals(i, queue.pop());
        }
    }

    @Test
    public void testPushAndPop(){
        //prepare
        ArrayQueue queue = new ArrayQueue();

        //when
        for(int i = 0 ; i < 5 ; i++){
            queue.push(i);
        }

        //then
        assertEquals(5, queue.size());

        for(int i = 0 ; i < 5 ; i++){
            assertEquals(i, queue.pop());
        }
    }

    @Test
    public void testArrayLengthExcessWithMinSize(){
        //prepare
        ArrayQueue queue = new ArrayQueue();

        //when
        for(int i = 0 ; i < 11 ; i++){
            queue.push(i);
        }
        for(int i = 0 ; i < 10 ; i++){
            queue.pop();
        }

        queue.push(11);

        //then
        assertEquals(2, queue.size());
    }

    @Test
    public void testPopIfEmpty(){
        //prepare
        ArrayQueue queue = new ArrayQueue();

        //when
        queue.push(null);

        //then
        assertNull(queue.pop());
    }

    @Test
    public void testPeek(){
        //prepare
        ArrayQueue queue = new ArrayQueue();

        //when
        for(int i = 0 ; i < 5 ; i++){
            queue.push(i);
        }

        //then
        for(int i = 0 ; i < 5 ; i++){
            assertEquals(i, queue.peek());
            assertEquals(i, queue.pop());
        }

    }

    @Test
    public void testResize(){
        //prepare
        ArrayQueue queue = new ArrayQueue();

        //when
        for(int i = 0 ; i < 15 ; i++){
            queue.push(i);
        }

        //then
        assertEquals(15, queue.size());
    }
}