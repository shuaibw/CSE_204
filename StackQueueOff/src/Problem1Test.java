import java.util.Scanner;

public class Problem1Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            try {
                System.out.println(Expression.evaluate(input));
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
}
