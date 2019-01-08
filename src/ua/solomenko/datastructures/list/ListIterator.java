package ua.solomenko.datastructures.list;

class ListIterator<E> {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        while (linkedList.iteratorHasNext()) {
            System.out.println(linkedList.iteratorNext());

        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        while (arrayList.iteratorHasNext()) {
            System.out.println(arrayList.iteratorNext());

        }
    }
}

