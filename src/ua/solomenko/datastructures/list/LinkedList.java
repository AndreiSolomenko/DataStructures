package ua.solomenko.datastructures.list;

public class LinkedList<E> implements List<E> {
    private Node first;
    private Node last;
    private int size;
    private int iteratorIndex;

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E value, int index) {
        validateIndexForAdd(index);

        Node node = new Node(value);
        if (size == 0) {
            first = last = node;
        } else if (index == 0) {
            node.setNext(first);
            first.setPrev(node);
            first = node;
        } else if (index == size) {
            last.setNext(node);
            node.setPrev(last);
            last = node;
        } else {
            Node temp = first;
            for (int i = 0 ; i < index ; i++) {
                temp = temp.getNext();
            }
            Node prev = temp.getPrev();
            prev.setNext(node);
            node.setPrev(prev);
            node.setNext(temp);
            temp.setPrev(node);
        }
        size++;
    }


    @Override
    public E remove(int index) {
        validateIndex(index);

        Node result = first;
        if (index == 0) {
            first = first.getNext();
            first.setPrev(null);
        } else if (index == size - 1) {
            last = last.getPrev();
            last.setNext(null);
        } else {
            for (int i = 0 ; i < index ; i++) {
                result = result.getNext();
            }
            result.getNext().setPrev(result.getPrev());
            result.getPrev().setNext(result.getNext());
        }
        size--;
        return result.getValue();
    }

    @Override
    public E get(int index) {
        validateIndex(index);

        Node result = first;
        for (int i = 0 ; i < index ; i++) {
            result = result.getNext();
        }
        return result.getValue();
    }

    @Override
    public E set(E value, int index) {
        validateIndex(index);

        E result;
        if (index == 0) {
            result = first.getValue();
            first.setValue(value);
        } else if (index == size - 1) {
            result = last.getValue();
            last.setValue(value);
        } else {
            Node temp = first;
            for (int i = 0 ; i < index ; i++) {
                temp = temp.getNext();
            }
            result = temp.getValue();
            temp.setValue(value);
        }
        return result;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != - 1;
    }

    @Override
    public int indexOf(Object value) {
        int index = - 1;
        Node result = first;
        if (value == null) {
            for (int i = 0 ; i < size ; i++) {
                if (null == result.getValue()) {
                    index = i;
                    break;
                } else {
                    result = result.getNext();
                }
            }
        } else {
            for (int i = 0 ; i < size ; i++) {
                if (value.equals(result.getValue())) {
                    index = i;
                    break;
                } else {
                    result = result.getNext();
                }
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index = - 1;
        Node result = last;
        if (value == null) {
            for (int i = size - 1 ; i >= 0 ; i--) {
                if (null == result.getNext()) {
                    index = i;
                    break;
                } else {
                    result = result.getNext();
                }
            }
        } else {
            for (int i = size - 1 ; i >= 0 ; i--) {
                if (value.equals(result.getValue())) {
                    index = i;
                    break;
                } else {
                    result = result.getPrev();
                }
            }
        }
        return index;
    }

    public boolean iteratorHasNext() {
        return iteratorIndex < size;
    }

    public E iteratorNext() {
        E res = (E) get(iteratorIndex);
        iteratorIndex++;
        return res;
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between [0, " + size + "], your index = " + index + ".");
        }
    }

    private void validateIndexForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between [0, " + size + "], your index = " + index + ".");
        }
    }

    private class Node {

        private E value;
        private Node next;
        private Node prev;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}



