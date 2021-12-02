package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {
    private static class Node {
        int val; //-1 if no representation
        int freq;
        Node left, right;

        private Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        private Node() {
            val = -1;
        }
    }

    public static Node huffman(Node[] ara) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.freq));
        for (int i = 0; i < ara.length; i++) {
            Node left = pq.remove();
            Node right = pq.remove();
            Node z = new Node();
            z.freq = left.freq + right.freq;
            z.left = left;
            z.right = right;
            pq.add(z);
        }
        return pq.remove();
    }

    public static void main(String[] args) {
        Node[] ara = new Node[]{
                new Node('f', 5),
                new Node('e', 9),
                new Node('c', 12),
                new Node('b', 13),
                new Node('d', 16),
                new Node('a', 45)
        };

    }
}
