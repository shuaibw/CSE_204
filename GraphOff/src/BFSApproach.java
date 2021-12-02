public class BFSApproach {
    private final Graph graph;
    private final int[] startNodes;

    public BFSApproach(Graph graph, int[] startNodes) {
        this.graph = graph;
        this.startNodes = startNodes;
    }

    public int[] haunt() {
        int[] pieceCounter = new int[startNodes.length];
        for (int i = 0; i < startNodes.length; i++) pieceCounter[i] = runBFS(startNodes[i]);
        return pieceCounter;
    }

    private int runBFS(int start) {
        DLL<Integer> queue = new DLL<>();
        int collected = 0;
        queue.addLast(start);
        boolean[] visited = new boolean[graph.size()];
        while (!queue.isEmpty()) {
            int city = queue.removeFirst();
            collected += graph.getValue(city);
            graph.setValue(city, 0);
            DLL<Integer> neighbors = graph.neighbors(city);
            for (Integer i : neighbors) {
                if (!visited[i]) {
                    queue.addLast(i);
                    visited[i] = true;
                }
            }
        }
        return collected;
    }
}
