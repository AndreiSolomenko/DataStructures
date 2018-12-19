package ua.solomenko.datastrucruers.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayStackTest {

    @Test
    public void testPushAndPop ( ) {
        //prepare
        ArrayStack stack = new ArrayStack ();

        //when
        for (int i = 0 ; i < 5 ; i++) {
            stack.push (i);
        }
        //{0 1 2 3 4}

        //then
        assertEquals (5, stack.size ());

        for (int i = 4 ; i >= 0 ; i--) {
            assertEquals (i, stack.pop ());
        }
    }

    @Test
    public void testPopIfEmpty ( ) {
        //prepare
        ArrayStack stack = new ArrayStack ();

        //when
        stack.push (null);

        //then
        assertNull (stack.pop ());
    }

    @Test
    public void testPeek ( ) {
        //prepare
        ArrayStack stack = new ArrayStack ();

        //when
        for (int i = 0 ; i < 5 ; i++) {
            stack.push (i);
        }

        //then
        for (int i = 4 ; i >= 0 ; i--) {
            assertEquals (i, stack.peek ());
            assertEquals (i, stack.pop ());
        }
    }

    @Test
    public void testResize ( ) {
        //prepare
        ArrayStack stack = new ArrayStack ();

        //when
        for (int i = 0 ; i < 15 ; i++) {
            stack.push (i);
        }

        //then
        assertEquals (15, stack.size ());
    }
}