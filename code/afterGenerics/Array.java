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

public class Array<Item extends Comparable<Item>> {
    private Item[] ara;
    private int N = 0;

    public Array() {
        ara = (Item[]) new Object[10];
    }

    public Array(int n) {
        if (n < 0) throw new IllegalArgumentException("Invalid length passed to constructor");
        ara = (Item[]) new Object[n];
    }

    public Array(Item[] A) {
        if (A == null) throw new IllegalArgumentException("Null array passed to constructor");
        N = A.length;
        ara = (Item[]) new Object[N];
        System.arraycopy(A, 0, ara, 0, N);
    }

    public Item[] getArray() {
        return Arrays.copyOfRange(ara, 0, N);
    }

    public Item getAnElement(int i) {
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

    public int[] findIndex(Item element) {
        if (element == null) throw new IllegalArgumentException("Null passed to findIndex(String element)");
        int[] indices = new int[N];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (ara[i].equals(element)) indices[j++] = i;
        }
        return Arrays.copyOfRange(indices, 0, j);
    }

    public Item[] subArray(int start, int end) {
        if (start >= N || start < 0 || end < 0 || end > N)
            throw new IndexOutOfBoundsException("Invalid indices passed to subArray");
        if (end < start) throw new IllegalArgumentException("End index greater than start index");
        return Arrays.copyOfRange(ara, start, end);
    }

    public void merge(Item[] A1, Item[] A2) {
        try {
            if (A1 == null || A2 == null)
                throw new IllegalArgumentException("Arrays passed to merge() must be non-null");
            isSorted(A1);
            isSorted(A2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        ara = (Item[]) new Object[A1.length + A2.length];
        int i = 0, j = 0, k = 0;
        while (i < A1.length && j < A2.length) {
            if (A1[i].compareTo(A2[j]) <= 0) ara[k++] = A1[i++];
            else ara[k++] = A2[j++];
        }
        while (i < A1.length) ara[k++] = A1[i++];
        while (j < A2.length) ara[k++] = A2[j++];
        N = k;
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

    private void isSorted(Item[] A) throws Exception {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i].compareTo(A[i + 1]) > 0) throw new Exception("Array not sorted");
        }
    }

    private void resize(int cap) {
        Item[] copy = (Item[]) new Object[cap];
        System.arraycopy(ara, 0, copy, 0, N);
        ara = copy;
    }

//    private void printStats() {
//        TreeMap<String, Integer> map = new TreeMap<>();
//        int cap = 0;
//        for (String s : ara) {
//            if (s != null) {
//                map.put(s, map.getOrDefault(s, 0) + 1);
//            } else {
//                map.put("NULL", map.getOrDefault("NULL", 0) + 1);
//            }
//        }
//        System.out.printf("%-15s    %s\n", "Data", "Occurrence");
//
//        for (Map.Entry<String, Integer> e : map.entrySet()) {
//            System.out.printf("%-15s == %4d\n", e.getKey(), e.getValue());
//        }
//        cap = map.values().stream().reduce(0, Integer::sum);
//        cap -= map.getOrDefault("NULL", 0);
//        System.out.println("Total:          ==   " + cap);
//        System.out.println("------------------------");
//    }

    public static void main(String[] args) {
    }

//    private static void debugTesting() {
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new File("src/data.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Array ara = new Array(15123);
//        assert scanner != null;
//        while (scanner.hasNext()) {
//            ara.add(scanner.next());
//        }
//        scanner.close();
//
//        ara.printStats();
//        ara.remove("charlotte");
//        ara.printStats();
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.add(2, "boeing");
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.add(2, "boeing");
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.add(2, "boeing");
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.add(2, "boeing");
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.remove("boeing");
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.remove("delta");
//        System.out.println(Arrays.toString(ara.getArray()));
//        ara.remove("cron");
//        System.out.println(Arrays.toString(ara.getArray()));
//        for (int i = 0; i < ara.size(); i++) {
//            System.out.println(ara.getAnElement(i));
//        }
//        System.out.println(Arrays.toString(ara.findIndex("tango")));
//        System.out.println(Arrays.toString(ara.subArray(2, 4))); //up-to but not including
//        String[] ara1 = new String[]{
//                "anwarul", "bashir", "cake", "david", "embargo"
//        };
//        String[] ara2 = new String[]{
//                "absolute", "diminish", "finish", "quarrel", "stupendous"
//        };
//        ara.merge(ara1, ara2);
//        ara.add(1, "starship");
//        ara.remove("starship");
//        System.out.println(Arrays.toString(ara.getArray()));
//        System.out.println(ara.length());
//        System.out.println(ara.size());
//        for (String s : ara1) {
//            ara.remove(s);
//        }
//        for (String s : ara2) {
//            ara.remove(s);
//        }
//        System.out.println(ara.size());
//        System.out.println(ara.length());
//        System.out.println(ara.isEmpty());
//        System.out.println(Arrays.toString(ara.getArray()));
//    }
}
