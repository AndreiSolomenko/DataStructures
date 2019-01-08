package ua.solomenko.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest extends AbstractStackTest {

    @Override
    public Stack getStackImplementation() {
        return new ArrayStack();
    }

    @Test
    public void testResize() {
        //prepare
        ArrayStack<Object> stack = new ArrayStack();

        //when
        for (int i = 0 ; i < 15 ; i++) {
            stack.push(i);
        }

        //then
        assertEquals(15, stack.size());
    }
}