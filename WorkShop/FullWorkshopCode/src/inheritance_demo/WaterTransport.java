package inheritance_demo;

public class WaterTransport extends Transport {

    private boolean isSailed;

    public void move(){
        System.out.println("Moving in water");
    }

    public WaterTransport(String model_Name, String registration_Number, boolean isSailed) {
        super(model_Name, registration_Number);
        this.isSailed = isSailed;
    }

    public WaterTransport(String modelName, String registrationNumber, int personCapacity, boolean isSailed) {
        super(modelName, registrationNumber, personCapacity);
        this.isSailed = isSailed;
    }
}
