package interface_demo;

import java.util.Arrays;

public class PrefilledRectangles {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(2, 30);
        Rectangle r2 = new Rectangle(12, 3);
        Rectangle r3 = new Rectangle(2, 13);
        Rectangle r4 = new Rectangle(21, 123);
        Rectangle r5 = new Rectangle(2, 35);


        Rectangle[] rects = {r1, r2, r3, r4, r5};
        Arrays.sort(rects);

        for(Rectangle rect:rects){
            rect.print();
            System.out.println(rect + " " + rect.getArea());
        }
    }
}
