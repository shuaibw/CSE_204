import java.util.Arrays;
import java.util.Scanner;

public class Rect {
    static class Coordinate {
        int x = -1, y = -1;

        Coordinate() {
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- != 0) {
            int n = Integer.parseInt(scanner.nextLine());
            Coordinate ara[] = new Coordinate[2];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    if (line.charAt(j) == '*') {
                        ara[idx] = new Coordinate();
                        ara[idx].x = i;
                        ara[idx].y = j;
                        idx++;
                    }
                }
            }
            Coordinate c1, c2, c3 = new Coordinate(), c4 = new Coordinate();
            c1 = ara[0];
            c2 = ara[1];
            if (c1.x == c2.x) {
                c3.y = c1.y;
                c4.y = c2.y;
                c3.x = (c1.x + 1) % n;
                c4.x = c3.x;
            } else if (c1.y == c2.y) {
                c3.y = (c1.y + 1) % n;
                c3.x = c1.x;
                c4.x = c2.x;
                c4.y = c3.y;
            } else {
                if (c1.x > c2.x) {
                    c3.x = c1.x;
                    c3.y = c2.y;
                    c4.x = c2.x;
                    c4.y = c1.y;
                } else {
                    c3.x = c2.x;
                    c3.y = c1.y;
                    c4.x = c1.x;
                    c4.y = c2.y;
                }
            }
            char[] str = new char[n];
            Arrays.fill(str, '.');
            StringBuilder[] sb = new StringBuilder[n];
            for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder(new String(str));
            sb[c1.x].setCharAt(c1.y, '*');
            sb[c2.x].setCharAt(c2.y, '*');
            sb[c3.x].setCharAt(c3.y, '*');
            sb[c4.x].setCharAt(c4.y, '*');
            for (StringBuilder s : sb) {
                System.out.println(s);
            }
        }
    }
}
