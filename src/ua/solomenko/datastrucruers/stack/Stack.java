package ua.solomenko.datastrucruers.stack;

public interface Stack<E> {

    // add value to the end of the stack
    void push(E object);

    // remove value from the end of the stack
    // return removed value
    E pop();

    // get value from the end of the stack
    E peek();

    // get stack size
    int size();
}