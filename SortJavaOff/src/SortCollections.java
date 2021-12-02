import java.util.Random;

public class SortCollections {
    private static Random random = new Random();

    public static void QuickSort(int[] ara) {
        QuickSort(ara, 0, ara.length - 1);
    }

    private static void QuickSort(int[] ara, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(ara, lo, hi);
        QuickSort(ara, lo, j - 1);
        QuickSort(ara, j + 1, hi);
    }

    private static int partition(int[] ara, int lo, int hi) {
//        int pivot = lo + random.nextInt(hi - lo + 1);
        int temp = ara[hi];
//        ara[hi] = ara[pivot];
//        ara[pivot] = temp;
        int x = ara[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (ara[j] < x) {
                i++;
                temp = ara[j];
                ara[j] = ara[i];
                ara[i] = temp;
            }
        }
        i++;
        temp = ara[i];
        ara[i] = ara[hi];
        ara[hi] = temp;
        return i;
    }

    public static void MergeSort(int[] ara) {
        int[] aux = new int[ara.length];
        MergeSort(ara, aux, 0, ara.length - 1);
    }

    private static void MergeSort(int[] ara, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        MergeSort(ara, aux, lo, mid);
        MergeSort(ara, aux, mid + 1, hi);
        Merge(ara, aux, lo, mid, hi);
    }

    private static void Merge(int[] ara, int[] aux, int lo, int mid, int hi) {
        System.arraycopy(ara, lo, aux, lo, hi - lo + 1);
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (aux[i] < aux[j]) ara[k++] = aux[i++];
            else ara[k++] = aux[j++];
        }
        while (i <= mid) ara[k++] = aux[i++];
        while (j <= hi) ara[k++] = aux[j++];
    }

    public static boolean isSorted(int[] ara) {
        for (int i = 0; i < ara.length - 1; i++) {
            if (ara[i] > ara[i + 1]) return false;
        }
        return true;
    }
}
