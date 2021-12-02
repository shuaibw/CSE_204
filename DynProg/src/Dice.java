import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dice {
    public int countWays(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(filePath));
        int dices, sum;
        dices = scanner.nextInt();
        sum = scanner.nextInt();
        int[] diceVal = new int[dices];
        for (int i = 0; i < dices; i++) diceVal[i] = scanner.nextInt();
        int mod = 1000000007;
        int[][] lookup = new int[dices][sum + 1];
        for (int i = 1; i <= sum; i++) lookup[0][i] = i <= diceVal[0] ? 1 : 0;
        for (int i = 1; i < dices; i++) {
            long window = 0; //slides over the previous row to calculate current cell value
            for (int j = 1; j <= sum; j++) {
                if (j > diceVal[i]) window -= lookup[i - 1][j - diceVal[i] - 1];
//                if (window < 0) window += mod;
                window += lookup[i - 1][j - 1];
                window = window % mod;
                lookup[i][j] = (int) window;
            }
        }
        scanner.close();
        return lookup[dices - 1][sum];
    }
}
