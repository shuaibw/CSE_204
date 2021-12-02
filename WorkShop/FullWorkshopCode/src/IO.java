import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

    public static void main(String[] args) throws Exception {

        //Java has many ways of doing IO
        //The way depends on choice and application

        //Use scanner for basic purposes
        //System.in is the standard input file
        Scanner scanner = new Scanner(System.in);

        float w = scanner.nextFloat();
        int x = scanner.nextInt();
        String y = scanner.nextLine();
        String z = scanner.next();

        System.out.println("w = " + w);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);

        // Also PrintWriter

        PrintWriter writer = new PrintWriter("hello.txt");
        writer.println("Writing in hello.txt");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String l1 = reader.readLine();
        System.out.println(l1);
        Scanner scanner2 = new Scanner(reader);
        System.out.println(scanner2.nextInt());
    }
}
