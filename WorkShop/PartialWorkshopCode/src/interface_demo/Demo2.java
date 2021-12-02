package interface_demo;

public class Demo2 {

    public static void main(String[] args) {
        Shape s1 = new Rectangle(5, 2);
        Shape s2 = new Triangle(3, 4, 5);


        System.out.println(s1.getArea());
        System.out.println(s2.getPerimeter());

        s1.printDefaultMethod();
        s2.printDefaultMethod();

        Shape.printStaticMethod();


    }
}
