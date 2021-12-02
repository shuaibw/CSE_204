package DivideNConquer;

public class TernarySearch {
    public static int solve(int[] ara, int target) {
        return ternSearch(ara, 0, ara.length - 1, target);
    }

    public static int ternSearch(int[] ara, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int piv1 = lo + (hi - lo) / 3;
        int piv2 = hi - (hi - lo) / 3;
        if (ara[piv1] == target) return piv1;
        if (ara[piv2] == target) return piv2;
        if (target < ara[piv1]) return ternSearch(ara, lo, piv1 - 1, target);
        if (target > ara[piv2]) return ternSearch(ara, piv2 + 1, hi, target);
        return ternSearch(ara, piv1 + 1, piv2 - 1, target);

    }

    public static void main(String[] args) {
        int[] ara = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solve(ara, 0));
    }
}
