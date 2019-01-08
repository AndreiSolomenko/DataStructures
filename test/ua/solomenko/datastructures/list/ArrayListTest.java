package ua.solomenko.datastructures.list;

public class ArrayListTest extends AbstractListTest {

    @Override
    public List getListImplementation() {
        return new ArrayList();
    }
}