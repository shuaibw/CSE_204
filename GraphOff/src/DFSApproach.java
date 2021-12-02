public class DFSApproach {
    private final Graph graph;
    private final int[] startNodes;
    private final boolean[] visited;

    public DFSApproach(Graph graph, int[] startNodes) {
        this.graph = graph;
        this.startNodes = startNodes;
        visited = new boolean[graph.size()];
    }

    public int[] haunt() {
        int[] pieceCounter = new int[startNodes.length];
        for (int i = 0; i < startNodes.length; i++) pieceCounter[i] = runDFS(startNodes[i]);
        return pieceCounter;
    }

    private int runDFS(int vertex) {
        if (visited[vertex]) return 0;
        visited[vertex] = true;
        int sum = graph.getValue(vertex);
        graph.setValue(vertex, 0);
        for (Integer i : graph.neighbors(vertex)) sum += runDFS(i);
        return sum;
    }

    private void runDFSIter(){

    }
}
