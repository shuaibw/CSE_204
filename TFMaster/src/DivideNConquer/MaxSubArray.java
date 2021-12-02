package DivideNConquer;

import java.util.Arrays;

public class MaxSubArray {
    public static int[] findMaxCrossingSubArray(int[] ara, int lo, int mid, int hi) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;
        int leftIdx = -1, rightIdx = -1;
        for (int i = mid; i >= lo; i--) {
            sum += ara[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIdx = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += ara[j];
            if (sum > rightSum) {
                rightSum = sum;
                rightIdx = j;
            }
        }
        return new int[]{leftIdx, rightIdx, leftSum + rightSum};
    }

    public static int[] findMaxSubArray(int[] ara, int lo, int hi) {
        if (lo == hi) return new int[]{lo, hi, ara[lo]}; //base
        int mid = lo + (hi - lo) / 2; //divide
        int[] leftMaxSubArray = findMaxSubArray(ara, lo, mid); //conquer
        int[] rightMaxSubArray = findMaxSubArray(ara, mid + 1, hi);  //conquer
        int[] crossMaxSubArray = findMaxCrossingSubArray(ara, lo, mid, hi); //combine
        if (leftMaxSubArray[2] >= rightMaxSubArray[2] && leftMaxSubArray[2] >= crossMaxSubArray[2])
            return leftMaxSubArray;
        else if (rightMaxSubArray[2] >= leftMaxSubArray[2] && rightMaxSubArray[2] >= crossMaxSubArray[2])
            return rightMaxSubArray;
        return crossMaxSubArray;
    }

    public static void main(String[] args) {
        int[] ara = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] ans = findMaxSubArray(ara, 0, ara.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(ans).toArray()));
    }
}
