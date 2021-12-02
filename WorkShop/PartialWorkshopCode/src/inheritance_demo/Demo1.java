package inheritance_demo;

public class Demo1 {

    public static void main(String ... args) {

        /*

            Tasks overview

            1. Instantiate Transport by Transport class constructor (when it is not abstract)
            2. Instantiate Transport by LandTransport class constructor
            3. Show that subclasses can access parent class members
            4. Show that when type is cast as the superclass, members defined anew in subclasses are not available
            5. Show polymorphism by the "move" method

         */

        LandTransport car = new LandTransport("Premio", "0364", 4);
        car.printHelloWorld();
        car.move();

        WaterTransport sBoat = new WaterTransport("Speedboat", "x1240", false);
        sBoat.printHelloWorld();
        sBoat.move();

        Transport plane = new AirTransport("Boeing 747", "IDK", 2);
        plane.printHelloWorld();
        plane.move();

        System.out.println(plane.getClass());

        //Transport transport = new Transport()

    }
}
