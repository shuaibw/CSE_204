package DynamicProgramming;

public class Highway {
    public static void solve(int[] x, int[] p, int mile, int t) {
        int[] rev = new int[mile + 1];
        int next = 0;
        for (int i = 1; i <= mile; i++) {
            if (next >= x.length) {
                rev[i] = rev[i - 1];
                continue;
            }
            if (i != x[next]) {
                rev[i] = rev[i - 1];
            } else {
                if (i <= t) rev[i] = Integer.max(rev[i - 1], p[next]);
                else rev[i] = Integer.max(rev[i - t - 1] + p[next], rev[i - 1]);
                next++;
            }
        }
        System.out.println(rev[mile]);
    }

    public static void main(String[] args) {
        int m = 20;
        int[] x = new int[]{6, 7, 12, 13, 14};
        int[] p = new int[]{5, 6, 5, 3, 1};
        int t = 5;
        solve(x, p, m, t);
    }
}
