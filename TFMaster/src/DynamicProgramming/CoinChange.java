package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static void solve(int money, int[] coins) {
        int[] min = new int[money + 1];
        int[] prev = new int[money + 1]; //contains the change amount for each index
        for (int i = 1; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) continue;
                int cur_min = min[i - coin] + 1;
                if (cur_min < min[i]) {
                    min[i] = cur_min;
                    prev[i] = coin;
                }
            }
        }
        System.out.println("DP array:");
        System.out.println(Arrays.toString(min));
        System.out.println("Optimal Reconstruction");
        int i = money;
        while (i != 0) {
            System.out.print(prev[i] + " ");
            i -= prev[i];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solve(20, new int[]{1, 7, 11, 15});
    }
}
