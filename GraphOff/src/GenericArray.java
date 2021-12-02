//Used for Arrays.copyOfRange() and Arrays.toString()

import java.util.Arrays;

/**
 * Anwarul Bashir Shuaib
 * 1805010
 * 08 March, 2021
 * <p>
 * All methods are guaranteed to be at most O(n) complexity in amortized analysis
 * Array length doubles iff number of elements >= array.length
 * Array length halves iff number of elements < array.length/4
 * This guarantees O(n) complexity even when calling successive insertion and deletion operations
 */

public class GenericArray<Item> {
    private Item[] ara;
    private int N = 0;

    public GenericArray() {
        ara = (Item[]) new Object[10];
    }

    public GenericArray(int n) {
        if (n < 0) throw new IllegalArgumentException("Invalid length passed to constructor");
        ara = (Item[]) new Object[n];
    }

    public GenericArray(Item[] A) {
        if (A == null) throw new IllegalArgumentException("Null array passed to constructor");
        N = A.length;
        ara = (Item[]) new Object[N];
        System.arraycopy(A, 0, ara, 0, N);
    }

    public Item[] getArray() {
        return Arrays.copyOfRange(ara, 0, N);
    }

    public Item get(int i) {
        if (i < 0 || i >= N) throw new ArrayIndexOutOfBoundsException(i);
        return ara[i];
    }

    public void add(Item element) {
        if (element == null) throw new IllegalArgumentException("Null passed to add()");

        if (N == ara.length) resize(N * 2);
        ara[N++] = element;
    }

    public void add(int idx, Item element) {
        if (idx >= N || idx < 0) throw new ArrayIndexOutOfBoundsException(idx);
        if (element == null) throw new IllegalArgumentException("Null passed to add(int idx, String element)");
        if (N == ara.length) resize(N * 2);
        for (int i = N - 1; i >= idx; i--) {
            ara[i + 1] = ara[i];
        }
        ara[idx] = element;
        N++;
    }

    public void remove(Item element) {
        if (element == null) throw new IllegalArgumentException("Null passed to remove(String element)");
        int j = 0;
        Item[] copy = (Item[]) new Object[ara.length];
        for (int i = 0; i < N; i++) {
            if (!ara[i].equals(element)) copy[j++] = ara[i];
        }
        ara = copy;
        N = j;
        if (N < ara.length / 4) resize(ara.length / 2);
    }

    public Item[] subArray(int start, int end) {
        if (start >= N || start < 0 || end < 0 || end > N)
            throw new IndexOutOfBoundsException("Invalid indices passed to subArray");
        if (end < start) throw new IllegalArgumentException("End index greater than start index");
        return Arrays.copyOfRange(ara, start, end);
    }

    /**
     * length() returns the actual length of the array, including the null elements
     */
    public int length() {
        return ara.length;
    }

    /**
     * size() returns the number of elements present in the array, excluding the null elements
     */
    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int cap) {
        Item[] copy = (Item[]) new Object[cap];
        System.arraycopy(ara, 0, copy, 0, N);
        ara = copy;
    }
}
