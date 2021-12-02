import java.util.Arrays;

public class HelloWorld {
    //Everything in Java is inside classes
    //There is no such thing as a global scope

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        //Java has two types of entities
        //Primitive types
        //Object types

        //Primitive types are boolean, byte, char, short, int, long, float, double

        boolean flag = true;
        char x = 'x';
        char y = 'ক'; //allows unicode characters

        int z = 47;
        double h = 1.23E-4;

        //we can print primitive types directly
        System.out.println("The value of h is " + h);
        //this is <sout + \tab> is IntelliJ IDEA

        //Boolean types and Java conditions
        //Boolean types are more restricted in Java than in C, C++ etc

        if (z != 0) {
            System.out.println("Z is non-zero.");
        }


        System.out.println(1.0 / 0.0);

        //Arrays

        int a1[] = {2, 3, 4, 5, 6};
        int[] a2 = {3, 4, 5};

        //Allocates a new array a3 of ten integers
        int[] a3 = new int[10];
        float a4[] = new float[5];

        //more on new later

        System.out.println(a2[2]);

        //Operators: somewhat like C
        //Statements
        //If-else
        //for( ; ; )

        for (int i = 0; i < 3; ++i) {
            System.out.print(a2[i] + " ");
        }
        System.out.println();

        //for(type x : xs)
        for (int c : a1) {
            System.out.print(c + " ");
        }
        System.out.println();

        Arrays.sort(a1);


        // Possible inclusions
        /*
            file I/O
            exception handling
         */

    }

}