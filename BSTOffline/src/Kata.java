

public class Kata {
    public static int[] beggars(int[] values, int n) {
        // show me the code!
        int[] home = new int[n];
        if (n == 0) return home;
        for (int i = 0; i < values.length; i++) {
            home[i % n] += values[i];
        }
        return home;
    }
}