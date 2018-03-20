public class Main {
    public static void main(String[] args) {

        System.out.println("\n================ POLIMORFIZM INKLUZYJNY ===============");
        System.out.println("\tVehicle vehicle = new Vehicle() \n\tvehicle.getNumberOfWheels()");
        Vehicle vehicle = new Vehicle();
        System.out.println("Ilość kół: " + vehicle.getNumberOfWheels());

        System.out.println("\tvehicle = new Car() \n\tvehicle.getNumberOfWheels()");
        vehicle = new Car();
        System.out.println("Ilość kół: " + vehicle.getNumberOfWheels());


        //System.out.println("\n================ AD HOC - KOERCJA ===============");
        Integer wi1 = new Integer(5); // pakowanie
        int i1 = wi1.intValue(); // rozpakowanie

        Integer wi2 = 5; // automatyczne pakowanie
        int i2 = wi2; // automatyczne rozp
        // System.out.println("=======================================================\n");


        System.out.println("\n================ AD HOC - PRZECIĄŻANIE ================");
        System.out.println("\tVehicle vehicleAH = new Car() \n\tVehicle vehicleAH = new Car()");
        Vehicle vehicleAH = new Car();
        Car carAH = new Car();
        System.out.println("vehicleAH.connectionWeight(vehicleAH)");
        vehicleAH.connectionWeight(vehicleAH);//A.m(A)
        System.out.println("vehicleAH.connectionWeight(carAH)");
        vehicleAH.connectionWeight(carAH);//A.m(A)
        System.out.println("carAH.connectionWeight(vehicleAH)");
        carAH.connectionWeight(vehicleAH);//A.m(A)
        System.out.println("carAH.connectionWeight(carAH)");
        carAH.connectionWeight(carAH);//B.m(B)


        System.out.println("\n============== POLIMORFIZM PARAMETRYCZNY ==============");                //można dodać jakies parametry do obieków i zrobić coś ciekawszego
        System.out.println("\tCrash<Car, Vehicle> p = new Crash<Car, Vehicle> (carPR, vehiclePR)");
        Vehicle vehiclePR = new Vehicle();
        Car carPR = new Car();

        Crash<Car, Vehicle> p = new Crash<Car, Vehicle> (carPR, vehiclePR);
        Car c = p.getFst();
        Vehicle v = p.getSnd();
        double fullMass = c.getWeight() + v.getWeight();
        System.out.println("Masa stłuczki = " + fullMass);

    }
}
