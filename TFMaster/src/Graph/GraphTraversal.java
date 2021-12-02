package Graph;

import java.util.ArrayList;

public class GraphTraversal {
    public static void main(String[] args) {
        ArrayList<Integer>[] adj = ReadGraph.readGraph("src/Graph/tree.txt", true);
        DFSRecurse(adj, 0, 0);
    }

    public static void DFSRecurse(ArrayList<Integer>[] adj, int cur, int tabs) {
//        if (cur >= adj.length) return;
        for (int i = 0; i < tabs; i++) System.out.print("\t");
        System.out.println(cur);
        for (Integer child : adj[cur]) {
            DFSRecurse(adj, child, tabs + 1);
        }
    }
}
