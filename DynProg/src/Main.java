import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new Dice().countWays("src/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
