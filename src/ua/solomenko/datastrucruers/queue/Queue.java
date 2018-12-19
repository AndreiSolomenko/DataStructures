package ua.solomenko.datastrucruers.queue;

public interface Queue<E> {

    // add value to the front of the queue
    void push(E object);

    // remove value from the beginning of the queue
    // return removed value
    E pop();

    // get value from the beginning of the queue
    E peek();

    // get queue size
    int size();
}