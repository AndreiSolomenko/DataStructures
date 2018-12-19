package ua.solomenko.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedStackTest {
    private LinkedStack linkedStack;

    @Before
    public void before ( ) {
        linkedStack = new LinkedStack ();
    }

    @Test
    public void testPushAndPop ( ) {

        //when
        linkedStack.push (1);
        linkedStack.push (2);
        linkedStack.push (3);

        //then
        assertEquals (3, linkedStack.pop ());
    }

    @Test
    public void testPopIfEmpty ( ) {

        //when
        linkedStack.push (null);

        //then
        assertNull (linkedStack.pop ());
    }

    @Test
    public void testPeek ( ) {

        //when
        linkedStack.push (1);
        linkedStack.push (2);
        linkedStack.push (3);

        //then
        assertEquals (3, linkedStack.peek ());
    }
}