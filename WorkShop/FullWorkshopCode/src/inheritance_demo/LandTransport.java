package inheritance_demo;

/*
    Every "LandTransport" is a Transport
 */

public class LandTransport extends Transport{

    /*
        1. extends keyword
        2. writing constructors, super keyword
        3. override methods
     */

    private int noWheels;

    public void move(){
        System.out.println("Moving in land");
    }

    public LandTransport(String model_Name, String registration_Number, int noWheels) {
        super(model_Name, registration_Number);
        this.noWheels = noWheels;
    }

    public LandTransport(String modelName, String registrationNumber, int personCapacity, int noWheels) {
        super(modelName, registrationNumber, personCapacity);
        this.noWheels = noWheels;
    }


}
