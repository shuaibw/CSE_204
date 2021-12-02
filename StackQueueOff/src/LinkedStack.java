import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedStack() {
    }

    public void push(Item item) {
        if (item == null) throw new IllegalArgumentException("null items cannot be added to stack");
        Node node = new Node();
        node.item = item;
        if (size == 0) first = node;
        else last.next = node;
        last = node;
        size++;
    }

    public Item pop() {
        if (size == 0) throw new UnsupportedOperationException("cannot delete from empty stack");
        Item item = last.item;
        if (first == last) {
            first = last = null;
            size--;
            return item;
        }
        Node current = first;
        while (current.next != last) current = current.next;
        current.next = null;
        last = current;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public Item peek() {
        if (size == 0) throw new UnsupportedOperationException("cannot peek from empty stack");
        return last.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String[] toArray() {
        String[] ara = new String[size];
        int idx = 0;
        for (Item item : this) {
            ara[idx++] = item.toString();
        }
        return ara;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
