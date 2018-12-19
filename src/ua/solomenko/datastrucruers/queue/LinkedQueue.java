package ua.solomenko.datastrucruers.queue;

public class LinkedQueue<E> implements Queue<E> {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void push(E object) {

        Node node = new Node(object);
        Node oldLast = last;
        last = node;
        if(first == null) {
            first = last;
        } else {
            oldLast.setNext(last);
        }
        size++;
    }

    @Override
    public E pop() {
        if (first == null) {
            return null;
        } else {
            E result = first.getObject();
            first = first.getNext();
            size--;
            return result;
        }
    }

    @Override
    public E peek() {
        if (first == null) {
            return null;
        } else {
            return first.getObject();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {

        private E object;
        private Node next;

        public Node(E object){
            this.object = object;
        }

        public E getObject() {
            return object;
        }

        public void setObject(E object) {
            this.object = object;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
