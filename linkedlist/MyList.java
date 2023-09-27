package linkedlist;

public interface MyList {
    void add(String value);
    void add(int index, String value);
    void set(int index, String value);
    String get(int index);
    void remove(int index);
    boolean contains(String value);
    int size();
}
