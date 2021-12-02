package DivideNConquer;

public class BinarySearch {
    public static int bSearch(int[] ara, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (ara[mid] == target) return mid;
        else if (target < ara[mid]) return bSearch(ara, lo, mid - 1, target);
        return bSearch(ara, mid + 1, hi, target);
    }

    public static void main(String[] args) {
        int[] ara=new int[]{0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(bSearch(ara, 0, ara.length-1, 5));
    }
}
