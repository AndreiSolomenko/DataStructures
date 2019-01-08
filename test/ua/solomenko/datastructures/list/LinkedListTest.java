package ua.solomenko.datastructures.list;

public class LinkedListTest extends AbstractListTest {

    @Override
    public List getListImplementation() {
        return new LinkedList();
    }
}