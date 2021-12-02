import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TestGen {
    public static void main(String[] args) throws IOException {
        Random random = new Random(5);
        int c = 250;
        int connections = 1500;
        int l_ = 230;
        int l = 0;
        int f = 25;
        int r = 0;
        int maxPiece = 66;
        boolean[][] roads = new boolean[c][c];
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/tests.txt"));
        for (int i = 0; i < connections; i++) {
            int x = random.nextInt(c);
            int y = random.nextInt(c);
            if (!roads[x][y]) {
                roads[x][y] = true;
                roads[y][x] = true;
                sb.append(String.format("%d %d\n", x, y));
                r++;
            }
        }
        ArrayList<Integer> ara = new ArrayList<>();
        for (int i = 0; i < l_; i++) {
            int x = random.nextInt(c);
            if (!ara.contains(x)) {
                ara.add(x);
                sb.append(String.format("%d %d\n", x, 1 + random.nextInt(maxPiece)));
                l++;
            }
        }
        ara.clear();
        for (int i = 0; i < f; i++) {
            int x = random.nextInt(c);
            sb.append(String.format("%d %d\n", x, i));
        }
        bw.write(String.format("%d %d %d %d\n", c, r, l, f) + sb);
        bw.close();
    }
}
