package DynamicProgramming;

public class ChainMatMul {
    public static void solve(int[] p) {
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length][p.length];
        for (int diff = 1; diff < p.length - 1; diff++) {
            for (int i = 1, j = i + diff; j < p.length; i++, j++) {
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Minimum Cost: " + m[1][p.length - 1]);
        System.out.println("Cost Table:");
        for (int i = 1; i < m.length; i++) {
            for (int j = i; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Reconstruction:");
        printOptimal(s, 1, s.length - 1);
    }

    public static void printOptimal(int[][] s, int i, int j) {
        if (i == j) System.out.print(i);
        else {
            System.out.print("(");
            printOptimal(s, i, s[i][j]);
            System.out.print(" * ");
            printOptimal(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
//    public static void solve(int[] p) {
//        int[][] m = new int[p.length - 1][p.length - 1];
//        int[][] s = new int[p.length - 1][p.length - 1];
//        for (int diff = 1; diff < m.length; diff++) {
//            for (int i = 0, j = i + diff; j < m.length; i++, j++) {
//                m[i][j] = Integer.MAX_VALUE;
//                for (int k = i; k < j; k++) {
//                    int cost = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
//                    if (cost < m[i][j]) {
//                        m[i][j] = cost;
//                        s[i][j] = k;
//                    }
//                }
//            }
//        }
//        System.out.println("Minimum Cost: " + m[0][m.length - 1]);
//    }

    public static void main(String[] args) {
        int[] p = new int[]{3,45,3,4,74,44};
        solve(p);
    }
}
