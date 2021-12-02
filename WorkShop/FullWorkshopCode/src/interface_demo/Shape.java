package interface_demo;

/*
  An interface is a contract that guarantees to a client how a class or struct will behave.
*/

/*

    Tasks:
    1. Understand what an interface is
 */

public interface Shape {

    //instance members not allowed

    //only functions
    //public by default
    double getArea();
    double getPerimeter();

    static void printStaticMethod(){
        System.out.println("A static method from shape");
    }

    default void printDefaultMethod(){
        System.out.println("A default method from shape");
    }

    //variables, if any, are static and must be initialized
    static int hello = 0;
}
