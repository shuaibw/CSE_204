import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ara = new int[n];
        for (int i = 0; i < n; i++) ara[i] = scanner.nextInt();
        Arrays.sort(ara);
        long sum = 0;
        for (int i = ara.length - 1, j = 0, m = k; i >= 0; i--, m--) {
            if (m == 0) {
                m = k;
                j++;
            }
            sum += (long) ara[i] * (j + 1);
        }
        System.out.println(sum);
    }
}
