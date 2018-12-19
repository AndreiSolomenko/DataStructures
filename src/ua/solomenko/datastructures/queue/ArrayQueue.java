package ua.solomenko.datastructures.queue;

public class ArrayQueue<E> implements Queue<E> {

    private E[] elements;
    private int size;
    private int front;

    public ArrayQueue() {
        this.elements = (E[]) new Object[10];
    }

    public ArrayQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public void push(E object) {
        if(size == elements.length) {
            resize();
        }

        if(front + size == elements.length) {
            System.arraycopy(elements, front, elements, 0, size);
            front = 0;
        }

        elements[front + size] = object;
        size++;
    }

    @Override
    public E pop() {
        if(size == 0) {
            return null;
        }
        E element = elements[front];
        elements[front] = null;
        front++;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(size == 0) {
            return null;
        }
        return elements[front];
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = (E[]) newElements;
    }
}