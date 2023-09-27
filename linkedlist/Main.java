package linkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, "item1");
        myLinkedList.add(1, "item2");
        myLinkedList.add(2, "item3");
        myLinkedList.add(3, "item4");
        myLinkedList.add(4, "item5");
        myLinkedList.add(5, "item6");
        myLinkedList.add(6, "item7");
        myLinkedList.add(7, "item8");
        myLinkedList.add(8, "item9");
        myLinkedList.add(9, "item10");
        myLinkedList.remove(9);
        myLinkedList.remove(5);
        myLinkedList.set(5, "item6");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

    }
}
