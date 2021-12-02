package DivideNConquer;

public class PeakElement {
    private static int peakRecurse(int[] ara, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if ((mid == 0 || ara[mid] >= ara[mid - 1]) && (mid == ara.length - 1 || ara[mid] >= ara[mid + 1])) return mid;
        if (mid > 0 && ara[mid] < ara[mid - 1]) return peakRecurse(ara, lo, mid - 1);
        return peakRecurse(ara, mid + 1, hi);
    }

    public static void main(String[] args) {
        int[] ara=new int[]{1, 3, 20, 4, 1, 0};
        System.out.println(peakRecurse(ara, 0, ara.length - 1));
    }
}
