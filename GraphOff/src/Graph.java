public class Graph {
    private class Vertex {
        int value;
        DLL<Integer> list;

        private Vertex(int value) {
            this.value = value;
            list = new DLL<>();
        }
    }

    private final GenericArray<Vertex> adjList = new GenericArray<>();

    public Graph(int size) {
        for (int i = 0; i < size; i++) {
            adjList.add(new Vertex(0));
        }
    }

    public DLL<Integer> neighbors(int id) {
        if (outOfBounds(id)) throw new IllegalArgumentException("Invalid id");
        return adjList.get(id).list;
    }

    public void connect(int a, int b) {
        if (outOfBounds(a) || outOfBounds(b))
            throw new IllegalArgumentException(a + " " + b);
        adjList.get(a).list.addLast(b);
        adjList.get(b).list.addLast(a);
    }

    public void setValue(int id, int value) {
        if (outOfBounds(id)) throw new IllegalArgumentException("Invalid id");
        adjList.get(id).value = value;
    }

    public int getValue(int id) {
        if (outOfBounds(id)) throw new IllegalArgumentException(("Invalid id"));
        return adjList.get(id).value;
    }

    public int size() {
        return adjList.size();
    }

    private boolean outOfBounds(int id) {
        return (id < 0 || id >= adjList.size());
    }
}
