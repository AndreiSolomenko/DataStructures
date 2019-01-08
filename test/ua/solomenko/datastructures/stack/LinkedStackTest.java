package ua.solomenko.datastructures.stack;

public class LinkedStackTest extends AbstractStackTest {

    @Override
    public Stack getStackImplementation() {
        return new LinkedStack();
    }
}