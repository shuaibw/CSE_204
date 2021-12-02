package inheritance_demo;

import java.util.Date;

public /*abstract*/ class Transport {

    /*

    Access modifiers
        private         --- only this class

        protected       --- this class
                        --- all its subclasses
                        --- all classes in this package

        public          --- any class anywhere

        <DEFAULT>       --- package private
                        --- this class
                        --- all classes in this package can access them

     */


    private String dPrivate;
    public String dPublic;
    protected String dProtected;
    /* package private */ String dPackagePrivate;


    private String modelName;
    private String registrationNumber;
    private double weight;
    private int personCapacity;


    // Task: write several constructors
    Transport()  {}
    public Transport(String model_Name, String registration_Number) {
        modelName = model_Name;
        registrationNumber = registration_Number;
    }

    public Transport(String modelName, String registrationNumber, int personCapacity) {
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.personCapacity = personCapacity;
    }

    // static members
    private static final double PoundsInKilogram = 2.205;
    public static double poundsToKilograms(double pounds) {
        // static members cannot access nonstatic members or "this" reference
        // the following line is erroneous
        // modelName = "hello";
        return pounds/PoundsInKilogram;
    }

    public static void main(String... args) {

        // Instantiate Transport only when it is not abstract
        Transport t = new Transport("Toyota Premio G Superior", "Dhaka Metro Ga 20-0364");
        t.printHelloWorld();

        // Another demo of constructor  and methods
        Date date = new Date();
        String dateString = date.toString();
        System.out.println(dateString);


        // Access static members from both class and instances
        System.out.println(t.poundsToKilograms(2.205));
        System.out.println(Transport.poundsToKilograms(4));

        System.out.println(Math.PI);

    }


    public void printHelloWorld() {
        System.out.println("Hello world from Transport class");
    }

    public void move() {
        System.out.println("Moving nowhere");
    }

    /*
        Tasks:
        1. Understand getters and setters and how to write them
        2. Generate getters and setters in IntelliJ
     */


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(int personCapacity) {
        this.personCapacity = personCapacity;
    }

}
