package ua.solomenko.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public abstract class AbstractStackTest {
    private Stack<Object> stack;

    public abstract Stack getStackImplementation();

    @Before
    public void before ( ) {
        stack = getStackImplementation();
    }

    @Test
    public void testPushAndPop ( ) {

        //when
        stack.push (1);
        stack.push (2);
        stack.push (3);

        //then
        assertEquals (3, stack.pop ());
    }

    @Test
    public void testPopIfEmpty ( ) {

        //when
        stack.push (null);

        //then
        assertNull (stack.pop ());
    }

    @Test
    public void testPeek ( ) {

        //when
        stack.push (1);
        stack.push (2);
        stack.push (3);

        //then
        assertEquals (3, stack.peek ());
    }
}
