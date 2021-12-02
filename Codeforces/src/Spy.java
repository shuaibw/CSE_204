import java.util.Scanner;

public class Spy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- != 0) {
            int a = scanner.nextInt();
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            if (p1 == p2) {
                for (int i = 2; i < a; i++) {
                    int k = scanner.nextInt();
                    if (k != p1) {
                        System.out.println(i + 1);
                        scanner.nextLine();
                        break;
                    }
                }
            } else {
                int k = scanner.nextInt();
                if (k == p1) System.out.println(2);
                else System.out.println(1);
                scanner.nextLine();
            }
        }
    }
}
