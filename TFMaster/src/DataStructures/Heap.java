package DataStructures;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap {
    ArrayList<Integer> ara;
    Comparator<Integer> comp;

    public Heap() {
        ara = new ArrayList<>();
        comp = Integer::compare;
    }

    public Heap(int[] data) {
        ara = new ArrayList<>();
        comp = Integer::compare;
        for (int i : data) {
            ara.add(i);
        }
        for (int i = ara.size() / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    private int left(int idx) {
        return ara.size() * 2 + 1;
    }

    private int right(int idx) {
        return ara.size() * 2 + 2;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private void siftDown(int idx) {
        while (idx < ara.size()) {
            int left = left(idx);
            int right = right(idx);
            int min = idx;
            if (left < ara.size() && ara.get(left) < ara.get(idx)) min = left;
            if (right < ara.size() && ara.get(right) < ara.get(idx)) min = right;
            if (min == idx) break;
            int temp = ara.get(idx);
            ara.set(idx, ara.get(min));
            ara.set(min, temp);
            idx = min;
        }
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = parent(idx);
            int min = idx;
            if (parent >= 0 && ara.get(parent) < ara.get(idx)) min = parent;
            if (min == idx) break;
            int temp = ara.get(idx);
            ara.set(idx, ara.get(min));
            ara.set(min, temp);
            idx = min;
        }
    }

    public void insert(int elem) {
        ara.add(elem);
        siftUp(ara.size() - 1);
    }

    public void deleteTop() {
        int temp = ara.get(0);
        int last = ara.size() - 1;
        ara.set(0, ara.get(last));
        ara.set(last, temp);
        ara.remove(last);
    }

    public void printHeap() {
        int idx = 0;
        for (int e = 0; (1 << (e - 1) < ara.size()); e++) {
            for (int i = 0; i < (1 << e) && idx < ara.size(); i++) {
                System.out.print((char) (int) ara.get(idx) + " ");
                idx++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] ara = new int[]{'X', 'R', 'T', 'Q', 'P', 'F', 'E', 'O', 'M', 'N', 'H', 'A', 'C', 'B', 'D'};
        Heap heap = new Heap(ara);
        heap.insert('S');
        heap.printHeap();

    }
}
