import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Mission {
    static class Location {
        int id;
        int pieces;

        Location(int id, int pieces) {
            this.id = id;
            this.pieces = pieces;
        }
    }

    public static void main(String[] args) {
        try {
            runMission();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runMission() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int cities = scanner.nextInt();
        int roads = scanner.nextInt();
        int locations = scanner.nextInt();
        int friends = scanner.nextInt();
        if (cities > 1000 || roads <= 1 || roads > (cities * (cities - 1)) / 2 || locations <= 1 || locations > cities || friends <= 1 || friends > 100)
            throw new Exception("Invalid input");
        int totalPieces = 0;
        Graph graph = new Graph(cities);
        int[] startNodes = new int[friends];
        for (int i = 0; i < roads; i++) {
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            if (c1 < 0 || c1 >= cities || c2 < 0 || c2 >= cities) throw new Exception("Invalid input");
            graph.connect(c1, c2);
        }
        Location[] loc = new Location[locations];
        for (int i = 0; i < locations; i++) {
            int id = scanner.nextInt();
            int pieces = scanner.nextInt();
            if (id < 0 || id >= cities) throw new Exception("Invalid input");
            loc[i] = new Location(id, pieces);
            totalPieces += pieces;
            graph.setValue(id, pieces);
        }
        for (int i = 0; i < friends; i++) {
            int start = scanner.nextInt();
            int friend = scanner.nextInt();
            if (start < 0 || start >= cities) throw new Exception("Invalid input");
            startNodes[friend] = start;
        }
        int[] pieceCounter = new BFSApproach(graph, startNodes).haunt();
        System.out.println("BFS approach:");
        printAndWrite(pieceCounter, totalPieces);
        for (Location location : loc) graph.setValue(location.id, location.pieces);
        pieceCounter = new DFSApproach(graph, startNodes).haunt();
        System.out.println("DFS approach:");
        printAndWrite(pieceCounter, totalPieces);
    }

    public static void printAndWrite(int[] pieceCounter, int totalPieces) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/solved.txt"));
        int sum = Arrays.stream(pieceCounter).sum();
        String res = (sum == totalPieces ? "Mission Successful" : "Mission Impossible") + "\n";
        System.out.print(res);
        bw.write(res);
        res = String.format("%d out of %d pieces are collected\n", sum, totalPieces);
        System.out.print(res);
        bw.write(res);
        for (int i = 0; i < pieceCounter.length; i++) {
            res = String.format("%d collected %d pieces\n", i, pieceCounter[i]);
            System.out.print(res);
            bw.write(res);
        }
        bw.close();
    }
}
