package inheritance_demo;


public class AirTransport extends Transport{

    private int noWings;

    public void move(){
        System.out.println("Moving in air");
    }

    public AirTransport(String model_Name, String registration_Number, int noWings) {
        super(model_Name, registration_Number);
        this.noWings = noWings;
    }

    public AirTransport(String modelName, String registrationNumber, int personCapacity, int noWings) {
        super(modelName, registrationNumber, personCapacity);
        this.noWings = noWings;
    }
}
