package ua.solomenko.datastrucruers.stack;

public class LinkedStack<E> implements Stack<E> {
    private Node last;
    private int size;

    @Override
    public void push(E object) {
        Node node = new Node(object);
        if(last != null) {
            node.setPrev(last);
        }
        last = node;
        size ++;
    }

    @Override
    public E pop() {
        if(last == null) {
            return null;
        } else {
            Node oldLast = last;
            last = oldLast.getPrev();
            E result = oldLast.getObject();
            oldLast.setPrev(null);
            oldLast = null;
            size --;
            return result;
        }
    }

    @Override
    public E peek() {
        if(last == null) {
            return null;
        } else {
            return last.getObject();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {

        private E object;
        private Node prev;

        public Node(E object){
            this.object = object;
        }

        public E getObject() {
            return object;
        }

        public void setObject(E object) {
            this.object = object;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

}