package DynamicProgramming;

public class RodCutting {
    public static void solve(int[] price, int n) {
        int[] r = new int[n + 1];
        int[] prev = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            r[i] = price[i];
            prev[i] = i;
            for (int j = 1; j < i; j++) {
                int newCost = r[i - j] + price[j];
                if (newCost > r[i]) {
                    r[i] = newCost;
                    prev[i] = j;
                }
            }
        }
        System.out.println("Optimal profit: " + r[n]);
        System.out.println("Reconstruction: ");
        while (n != 0) {
            System.out.print(prev[n] + " ");
            n -= prev[n];
        }

    }

    public static void main(String[] args) {
        int[] price = new int[]{Integer.MIN_VALUE, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        solve(price, 10);
    }
}
