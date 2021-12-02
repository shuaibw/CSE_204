import java.util.Scanner;

public class Problem2Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            try {
                System.out.println(NewString.convert(input));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
