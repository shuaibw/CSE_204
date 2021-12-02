import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenericArr<Item extends Comparable<Item>> {
    private int N = 0;
    private Item[] ara;

    public GenericArr() {
        ara = (Item[]) new Object[16];
    }

    public GenericArr(Item[] s) {
        ara = (Item[]) new Object[s.length];
        while (N < ara.length) {
            ara[N] = s[N];
            N++;
        }
    }

    public int size() {
        return N;
    }

    public GenericArr(int size) {
        ara = (Item[]) new Object[size];
    }

    public Item[] getArray() {
        return ara;
    }

    public Item getAnElement(int i) {
        if (i >= ara.length) throw new ArrayIndexOutOfBoundsException(i);
        return ara[i];
    }

    public void add(Item item) {
        if (N == ara.length) resize(N * 2);
        ara[N++] = item;
    }

    public void add(int i, Item item) {
        if (i >= ara.length) throw new ArrayIndexOutOfBoundsException(i);
        if (N == ara.length) resize(N * 2);
        for (int idx = N - 1; idx >= i; idx--) {
            ara[idx + 1] = ara[idx];
        }
        ara[i] = item;
        N++;
    }

    public void remove(Item item) {
        int count = countItem(item);
        if (count == 0) return;
        int cap = 1;
        while (cap < (N - count)) cap *= 2;
        Item[] copy = (Item[]) new Object[cap];
        for (int i = 0, j = 0; i < N; i++) {
            if (ara[i] != item) copy[j++] = ara[i];
        }
        N -= count;
        ara = copy;
    }

    public int[] findIndex(Item item) {
        int count = countItem(item);
        int[] occurrences = new int[count];
        for (int i = 0, j = 0; i < N; i++) {
            if (ara[i] == item) occurrences[j++] = i;
        }
        return occurrences;
    }

    public Item[] subArray(int start, int end) {
        if (start >= N || start < 0 || end < 0 || end >= N) throw new IndexOutOfBoundsException();
        Item[] slice = (Item[]) new Object[end - start + 1];
        for (int i = start; i < end; i++) {
            slice[i] = ara[i];
        }
        return slice;
    }

    public void merge(Item[] A1, Item[] A2) {
        try {
            isSorted(A1);
            isSorted(A2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Item[] merged = (Item[]) new Object[A1.length + A2.length];
        int minIdx = Integer.min(A1.length, A2.length);
        int idx = 0;
        for (idx = 0; idx < minIdx; idx++) {
            if (A1[idx].compareTo(A2[idx]) <= 0) merged[idx] = A1[idx];
            else merged[idx] = A2[idx];
        }
        Item[] left = (minIdx == A1.length) ? A1 : A2;
        while (idx < merged.length) merged[idx] = left[idx];
        ara = merged;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void isSorted(Item[] items) throws Exception {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i].compareTo(items[i + 1]) > 0) throw new Exception("GenericArr not sorted");
        }
    }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            copy[i] = ara[i];
        }
        ara = copy;
    }

    private int countItem(Item item) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (ara[i].compareTo(item) == 0) count++;
        }
        return count;
    }

    private void showStats() {
        HashMap<Item, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(ara[i], map.getOrDefault(ara[i], 0) + 1);
        }
        for (Map.Entry<Item, Integer> i : map.entrySet()) {
            System.out.println(i.getKey() + " : " + i.getValue());
        }
    }

    public static void main(String[] args) {
        GenericArr<Integer> ara = new GenericArr<>();
        Random random = new Random(1);
        for (int i = 0; i < 100; i++) {
            ara.add(random.nextInt(30));
            ara.add(random.nextInt(30));
        }
        ara.showStats();
        System.out.println(ara.getAnElement(3));
        ara.add(2, 223);
        ara.remove(10);
        ara.showStats();
        for (int i : ara.findIndex(14)) {
            System.out.println(i);
        }


    }
}
