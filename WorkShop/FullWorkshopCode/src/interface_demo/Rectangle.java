package interface_demo;

/*
    Tasks:
    1. Multiple inheritance by interfaces
    2. Comparable
 */

public class Rectangle implements Shape, Comparable {

    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a*b;
    }

    @Override
    public double getPerimeter() {
        return a+a+b+b;
    }

    @Override
    public void printDefaultMethod() {
        System.out.println("Overridden in Rectangle class");
    }

    //Static method can be overridden too
    /*
    public static void printStaticMethod() {
        System.out.println("Overridden static method");
    }
    */


    /*
        compareTo convention

        a.compareTo(b) returns
            1       if a>b
            0       if a==b
            -1      if a<b
     */
    /*
        Tasks
        1. Understand Object class and its position in class hierarchy
        2. While casting the class, talk about exceptions
     */
    @Override
    public int compareTo(Object o) {
        Rectangle r = (Rectangle) o;
        return Double.compare(this.getArea(), r.getArea());
    }

    public void print() {
        System.out.print("a = " + a);
        System.out.println("; b = " + b);
    }

    /*
    Tasks:
        1. understand toString
     */
    @Override
    public String toString() {
        return "Rectangle of our wish {" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

