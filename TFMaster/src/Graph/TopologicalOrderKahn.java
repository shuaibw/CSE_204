package Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalOrderKahn {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer>[] adj = ReadGraph.readGraph("src/Graph/kahninput.txt", true);
        int[] order = topOrder(adj);
        if (order == null) System.out.println("Cyclic!");
        else System.out.println(Arrays.toString(order));
    }

    private static int[] topOrder(ArrayList<Integer>[] adj) {
        int[] inDeg = new int[adj.length];
        Queue<Integer> q = new LinkedList<>(); //Change to PriorityQueue for LexOrder
        for (ArrayList<Integer> v : adj) {
            for (Integer n : v) {
                inDeg[n]++;
            }
        }
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) q.add(i);
        }
        int idx = 0;
        int[] order = new int[adj.length];
        while (!q.isEmpty()) {
            int x = q.remove();
            order[idx++] = x;
            for (Integer n : adj[x]) {
                inDeg[n]--;
                if (inDeg[n] == 0) q.add(n);
            }
        }
        if (idx != adj.length) return null;
        return order;
    }
}
