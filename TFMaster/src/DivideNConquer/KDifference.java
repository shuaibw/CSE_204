package DivideNConquer;

import java.util.Arrays;

public class KDifference {
    private class Pair {
        int a, b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void solve(int[] ara, int k) {
        Arrays.sort(ara);
        for (int i = 0; i < ara.length; i++) {
            while (i < (ara.length - 1) && ara[i] == ara[i + 1]) i++;
            int idx = Arrays.binarySearch(ara, ara[i] - k);
            if (idx >= 0) System.out.println(ara[i] + " " + ara[idx]);
        }
    }

    public static void main(String[] args) {
        int[] ara = new int[]{1, 5, 2, 2, 2, 5, 5, 4};
        solve(ara, 3);
    }
}
