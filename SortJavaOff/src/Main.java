import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    enum SortType {
        Mergesort,
        Quicksort
    }

    enum ArrayType {
        Random,
        Ascending,
        Descending
    }

    public static int runs = 500;
    public static final int startSize = 10;
    public static final int endSize = 1000000;
    public static final int expo = 10;
    public static Random random = new Random();

    public static void main(String[] args) {
        new Thread(null, Main::userAnalytics, "2", (long) 1 << 31).start();
//        masterAnalytics();
    }

    private static void userAnalytics() {
        Scanner scanner = new Scanner(System.in);
        int n;
        String order;
        runs = 1;
        ArrayType arrayType;
        while (true) {
            try {
                System.out.print("Enter size: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n == -1) break;
                System.out.print("Enter order: ");
                order = scanner.nextLine();
                arrayType = ArrayType.valueOf(order);
            } catch (Exception e) {
                System.out.println("Invalid input, try again or n=-1 to quit.");
                continue;
            }
            double[] times = Sort(arrayType, n, true);
            System.out.printf("%-10s %-10s %-10s\n", "Size", "Algo", "Time (ms)");
            System.out.printf("%-10d %-10s %-10.5f\n", n, "Mergesort", times[0]);
            System.out.printf("%-10d %-10s %-10.5f\n", n, "Quicksort", times[1]);
        }
    }

    private static void masterAnalytics() {
        new Thread(null, () -> {
            computeAnalytics(ArrayType.Random);
            computeAnalytics(ArrayType.Ascending);
            computeAnalytics(ArrayType.Descending);
        }, "1", (long) 1 << 31).start();
    }

    private static void computeAnalytics(ArrayType arrayType) {
        System.out.printf("%-10s %-10s %-10s %s\n", "Magnitude", "Algo", "Time (ms)", arrayType.toString().toUpperCase());
        for (int i = startSize, mag = 1; i <= endSize; i *= expo, mag++) {
            double[] times = Sort(arrayType, i, false);
            System.out.printf("%-10d %-10s %-10f\n", mag, "Mergesort", times[0]);
            System.out.printf("%-10d %-10s %-10f\n", mag, "Quicksort", times[1]);
            System.out.println("-------------------------------");
        }
    }

    private static double[] Sort(ArrayType arrayType, int size, boolean print) {
        long[] mergeTime = new long[runs];
        long[] quickTime = new long[runs];
        int[] ara1 = new int[size];
        int[] ara2 = new int[size];

        for (int i = 0; i < runs; i++) {
            fillArray(ara1, arrayType);
            System.arraycopy(ara1, 0, ara2, 0, size);

            long startTime = System.nanoTime();
            SortCollections.MergeSort(ara1);
            long endTime = System.nanoTime();
            mergeTime[i] = endTime - startTime;
            assert SortCollections.isSorted(ara1);

            startTime = System.nanoTime();
            SortCollections.QuickSort(ara2);
            endTime = System.nanoTime();
            quickTime[i] = endTime - startTime;
            assert SortCollections.isSorted(ara2);

        }
        double mergeAvg = (double) Arrays.stream(mergeTime).sum() / (1000000 * runs);
        double quickAvg = (double) Arrays.stream(quickTime).sum() / (1000000 * runs);
        if (print) printAra(ara1, ara2);
        return new double[]{mergeAvg, quickAvg};
    }

    private static void printAra(int[] ara1, int[] ara2) {
        assert ara1.length == ara2.length;
        System.out.println("Printing two arrays side by side");
        for (int i = 0; i < ara1.length; i++) {
            System.out.printf("%-15d %-15d\n", ara1[i], ara2[i]);
        }
    }

    private static void fillArray(int[] ara, ArrayType arrayType) {
        int beg = random.nextInt();
        if (beg < 0 && Math.abs(Integer.MIN_VALUE - beg) > ara.length) beg += ara.length;
        else if (beg > 0 && Math.abs(Integer.MAX_VALUE - beg) > ara.length) beg -= ara.length;
        if (arrayType == ArrayType.Random) {
            for (int i = 0; i < ara.length; i++) ara[i] = random.nextInt();
        } else if (arrayType == ArrayType.Ascending) {
            for (int i = 0; i < ara.length; i++) ara[i] = beg++;
        } else {
            for (int i = 0; i < ara.length; i++) ara[i] = beg--;
        }
    }
}
