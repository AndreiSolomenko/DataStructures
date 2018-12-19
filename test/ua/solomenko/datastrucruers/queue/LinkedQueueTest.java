package ua.solomenko.datastrucruers.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedQueueTest{
    private LinkedQueue linkedQueue;

    @Before
    public void before(){
        linkedQueue = new LinkedQueue();
    }

    @Test
    public void testPushAndPop(){

        //when
        linkedQueue.push(1);
        linkedQueue.push(2);
        linkedQueue.push(3);

        //then
        assertEquals(1, linkedQueue.pop());
        assertEquals(2, linkedQueue.pop());
    }

    @Test
    public void testPopIfEmpty(){

        //when
        linkedQueue.push(null);

        //then
        assertNull(linkedQueue.pop());
    }

    @Test
    public void testPopAndPeek(){

        //when
        linkedQueue.push(1);
        linkedQueue.push(2);
        linkedQueue.push(3);

        //then
        assertEquals(1, linkedQueue.pop());
        assertEquals(2, linkedQueue.peek());
    }
}





