import java.util.Iterator;

public class DLL<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node first, last;

    private int size;

    public DLL() {
        first = last = null;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Argument Item cannot be null");
        Node node = new Node();
        node.item = item;
        node.next = first;
        if (first != null) first.prev = node;
        else last = node;
        first = node;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Argument Item cannot be null");
        Node node = new Node();
        node.item = item;
        node.prev = last;
        if (last != null) last.next = node;
        else first = node;
        last = node;
        size++;
    }

    public void addBefore(Item item, int idx) {
        if (item == null) throw new IllegalArgumentException("Argument Item cannot be null");
        if (size == 0)
            throw new UnsupportedOperationException("List must contain at least one item to support addBefore()");
        if (idx >= size || idx < 0) throw new IllegalArgumentException("Invalid index passed to addBefore()");
        Node current = getNode(idx);
        Node node = new Node();
        node.item = item;
        node.next = current;
        node.prev = current.prev;
        if (current != first) current.prev.next = node;
        else first = node;
        current.prev = node;
        size++;
    }

    public void addAfter(Item item, int idx) {
        if (item == null) throw new IllegalArgumentException("Argument Item cannot be null");
        if (size == 0)
            throw new UnsupportedOperationException("List must contain at least one item to support addAfter()");
        if (idx >= size || idx < 0) throw new IllegalArgumentException("Invalid index passed to addAfter()");
        Node current = getNode(idx);
        Node node = new Node();
        node.item = item;
        node.prev = current;
        node.next = current.next;
        if (current != last) current.next.prev = node;
        else last = node;
        current.next = node;
        size++;
    }

    public void removeFirst() {
        if (size == 0) throw new RuntimeException("List already empty");
        if (size == 1) first = last = null;
        else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) throw new RuntimeException("List already empty");
        if (size == 1) last = first = null;
        else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    public void remove(int idx) {
        if (idx >= size || idx < 0) throw new IllegalArgumentException("Invalid index passed to remove()");
        Node current = getNode(idx);
        if (current != first && current != last) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        } else if (current == first) removeFirst();
        else removeLast();
    }

    public String getSequence(int idx, boolean reverse) {
        Node current = getNode(idx);
        Node iter = current;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(iter.item.toString()).append(", ");
            if (reverse) {
                if (iter.prev != null) iter = iter.prev;
                else iter = getNode(size - 1);
            } else {
                if (iter.next != null) iter = iter.next;
                else iter = getNode(0);
            }
        } while (iter != current);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public Item getItem(int idx) {
        if (idx >= size || idx < 0) throw new IllegalArgumentException("Invalid index passed to getItem()");
        Node current = first;
        for (int i = 0; i < idx; i++) current = current.next;
        return current.item;
    }

    private Node getNode(int idx) {
        Node current = first;
        for (int i = 0; i < idx; i++) current = current.next;
        return current;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (Item p : this) {
            System.out.print(p + " ");
        }
        System.out.println();
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
