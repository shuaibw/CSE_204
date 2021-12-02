package Graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadGraph {
    public static ArrayList<Integer>[] readGraph(String file, boolean directed) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[vertices];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj[x].add(y);
            if (!directed) adj[y].add(x);
        }
        return adj;
    }
}
