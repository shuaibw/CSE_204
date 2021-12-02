package DataStructures;

import java.util.Arrays;

public class UF {
    private final int[] id;
    private final int[] sz;
    private int count;

    UF(int n) {
        id = new int[n];
        sz = new int[n];
        Arrays.fill(sz, 1);
        for (int i = 0; i < n; i++) id[i] = i;
        count = n;
    }

    public int count() {
        return count;
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}