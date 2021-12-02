package DivideNConquer;

import java.util.Arrays;
import java.util.Random;

public class MaxMin18_19 {
    public static int max(int[] ara, int lo, int hi) {
        if (hi == lo) return ara[lo];
        int mid = lo + (hi - lo) / 2;
        int leftMax = max(ara, lo, mid);
        int rightMax = max(ara, mid + 1, hi);
        if (leftMax >= rightMax && leftMax >= ara[mid]) return leftMax;
        else if (rightMax >= leftMax && rightMax >= ara[mid]) return rightMax;
        return ara[mid];
    }

    public static int min(int[] ara, int lo, int hi) {
        if (hi == lo) return ara[lo];
        int mid = lo + (hi - lo) / 2;
        int leftMin = min(ara, lo, mid);
        int rightMin = min(ara, mid + 1, hi);
        if (leftMin <= rightMin && leftMin <= ara[mid]) return leftMin;
        else if (rightMin <= leftMin && rightMin <= ara[mid]) return rightMin;
        return ara[mid];
    }

    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            int[] ara = new int[random.nextInt(1000) + 1];
            for (int i = 0; i < ara.length; i++) {
                ara[i] = random.nextInt();
            }
            int trueVal = Arrays.stream(ara).min().getAsInt();
            int algoVal = min(ara, 0, ara.length - 1);
            if (trueVal != algoVal) {
                System.out.println(trueVal + " " + algoVal);
            }
        }
    }
}
