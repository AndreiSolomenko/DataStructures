package ua.solomenko.datastrucruers.list;

public class ArrayList<E> implements List<E> {

    private E[] elements;
    private int size;

    public ArrayList() {
        this.elements = (E[]) new Object[10];
    }

    public ArrayList(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between [0, " + size + "], your index = " + index + ".");
        }

        if (size == elements.length) {
            resize();
        }
        if (index != size) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = value;
        size++;
    }


    @Override
    public E remove(int index) {
        validateIndex(index);

        E oldValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        sizeDecreas();

        return oldValue;
    }

    @Override
    public E get(int index) {
        validateIndex(index);

        return elements[index];
    }

    @Override
    public E set(E value, int index) {
        validateIndex(index);

        E oldValue = elements[index];
        elements[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0 ; i < size ; i++) {
            elements[i] = null;
        }
        size = 0;
        sizeDecreas();
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
        if (value == null) {
            for (int i = 0 ; i < size ; i++) {
                if (null == elements[i]) {
                    return i;
                }
            }
        } else {
            for (int i = 0 ; i < size ; i++) {
                if (value.equals(elements[i])) {
                    return i;
                }
            }
        }
        return - 1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size - 1 ; i >= 0 ; i--) {
                if (null == elements[i]) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1 ; i >= 0 ; i--) {
                if (value.equals(elements[i])) {
                    return i;
                }
            }
        }
        return - 1;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = (E[]) newElements;
    }

    private void sizeDecreas() {
        if (size == 0.25 * elements.length && elements.length > 10) {
            Object[] newElements = new Object[elements.length / 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = (E[]) newElements;
        }
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be between [0, " + size + "], your index = " + index + ".");
        }
    }
}