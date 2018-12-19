package ua.solomenko.datastrucruers.stack;

public class ArrayStack<E> implements Stack<E> {

    private E[] elements;
    private int size;

    public ArrayStack() {
        this.elements = (E[]) new Object[10];
    }

    public ArrayStack(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public void push(E object) {
        if(size == elements.length) {
            resize();
        }
        elements[size] = object;
        size++;
    }

    @Override
    public E pop() {
        if(size == 0) {
            return null;
        }
        E element = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(size == 0) {
            return null;
        }
        return elements[size - 1];
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
