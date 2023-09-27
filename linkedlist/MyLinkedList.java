package linkedlist;

public class MyLinkedList implements MyList {
    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    @Override
    public void add(String value) {
        Node node;
        if (size == 0) {
            node = new Node(null, null, value);
            first = node;
        } else {
            node = new Node(last, null, value);
            last.setNext(node);

        }
        last = node;
        size++;

    }

    @Override
    public void add(int index, String value) {
        Node newNode = new Node(null, null, value);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (size == 0) {
            // Adding to an empty list
            first = newNode;
            last = newNode;
        } else if (index == 0) {
            // Adding at the beginning of the list
            Node current = first;
            newNode.setNext(current);
            current.setPrev(newNode);
            first = newNode;
        } else if (index == size) {
            // Adding at the end of the list
            Node lastNode = last;
            newNode.setPrev(lastNode);
            lastNode.setNext(newNode);
            last = newNode;
        } else {
            // Adding at a specific index
            Node current = getNode(index);
            Node prev = current.getPrev();
            newNode.setNext(current);
            newNode.setPrev(prev);
            prev.setNext(newNode);
            current.setPrev(newNode);
        }
        size++;

    }
    @Override
    public void set(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        getNode(index).setValue(value);
    }

    @Override
    public String get(int index) {
        Node current = first;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        else if (index == 0 && size > 1) {
            Node node = first;
            Node nextNode = node.getNext();
            nextNode.setPrev(null);
            first = nextNode;
        }
        else if (index == size-1 && size > 1) {
            Node node = last;
            Node prevNode = node.getPrev();
            prevNode.setNext(null);
            last = prevNode;
        }
        else if (index > 0 && index < size) {
            Node node = getNode(index);
            Node prevNode = node.getPrev();
            Node nextNode = node.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        } else {
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public boolean contains(String value) {
        for (Node node = first; node != null; node = node.getNext()) {
            if (node.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int size() {
        return size;
    }
    public Node getNode(int index) {
        Node current = first;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
