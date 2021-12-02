import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item>{
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedQueue() {

    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("null items cannot be added to queue");
        Node node = new Node();
        node.item = item;
        if (size == 0) first = node;
        else last.next = node;
        last = node;
        size++;
    }

    public Item dequeue() {
        if (size == 0) throw new UnsupportedOperationException("cannot delete from empty queue");
        Item item = first.item;
        first = first.next;
        if (size == 1) last = null;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public Item peek() {
        if (size == 0) throw new UnsupportedOperationException("cannot peek from empty queue");
        return first.item;
    }

    public boolean isEmpty() {
        return size == 0;
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
