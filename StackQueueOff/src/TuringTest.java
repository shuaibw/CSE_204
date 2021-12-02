import java.util.Arrays;
import java.util.Random;

public class TuringTest {
    public static void main(String[] args) {
        Random r = new Random();
        int[] ara = new int[15];
        for (int i = 0; i < ara.length; i++) ara[i] = r.nextInt(2);
        for (int i = 0; i < ara.length; i++) {
            if (ara[i] == 1) {
                ara[i] = i % 2;
                i = (2 * i + 1) % ara.length;
            } else {
                ara[i] = 1 - i % 2;
                i = (3 * i + 1) % ara.length;
            }
            System.out.println(Arrays.toString(ara));
        }
    }
}
