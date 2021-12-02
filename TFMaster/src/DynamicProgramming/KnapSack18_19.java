package DynamicProgramming;

import java.util.Arrays;

public class KnapSack18_19 {
    public static int solve(int[] items, int[] values, int weight) {
        assert items.length == values.length;
        int[][] dpTable = new int[items.length + 1][weight + 1];
        for (int i = 1; i <= items.length; i++) {
            for (int w = 1; w <= weight; w++) {
                int cut = items[i - 1];
                int val = values[i - 1];
                dpTable[i][w] = dpTable[i - 1][w];
                if (cut > w) continue;
                dpTable[i][w] = Integer.max(dpTable[i - 1][w - cut] + val, dpTable[i - 1][w]);
            }
        }
        int[] solution = new int[items.length]; //Reconstruct
        for (int i = items.length, j = weight; i > 0; i--) {
            int w = items[i - 1];
            if (dpTable[i][j] == dpTable[i - 1][j]) {
                solution[i - 1] = 0;
            } else {
                solution[i - 1] = 1;
                j -= w;
            }
        }
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.deepToString(dpTable).replace("], ", "]\n"));
        return dpTable[items.length][weight];
    }

    public static void main(String[] args) {
        int[] items = new int[]{6, 3, 4, 2};
        int[] values = new int[]{30, 14, 16, 9};
        System.out.println(solve(items, values, 10));
    }
}
