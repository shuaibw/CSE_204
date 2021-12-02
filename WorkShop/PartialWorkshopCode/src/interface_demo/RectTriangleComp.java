package interface_demo;

import java.time.Clock;
import java.util.Random;

public class RectTriangleComp {

    // Show how to throw Exceptions
    static void randomExceptionGenerator() throws Exception {
        // Write anything you wish to throw an Exception
        return;
    }

    public static void main(String[] args){

        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(10, 20);
        Triangle t1 = new Triangle(3, 4, 5);

        int[] a = {3, 4, 5};

        System.out.println(r1.compareTo(r2));

        /*
            See how exceptions work
            1. Class cast exception
            2. Arithmetic exception
            3. User generated exception
        */

        try {
            //int y = a[4];
            //System.out.println(r1.compareTo(t1));
            randomExceptionGenerator();
        } catch (ClassCastException e) {
            System.out.println(e.toString());
        } catch (Exception e1) {
            System.out.println(e1.toString());
        } finally {
            System.out.println("This will be executed.");
        }


        System.out.println("The code goes on.");
    }
}
