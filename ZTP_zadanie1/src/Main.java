public class Main {
    public static void main(String[] args) {

        System.out.println("\n================ POLIMORFIZM INKLUZYJNY ===============");
        System.out.println("\tCar car = new Car(); \n\tcar.getNumberOfWheels()");
        Car car = new Car();
        System.out.println("Ilość kół: " + car.getNumberOfWheels());
        System.out.println("\tcar = new SpecialCar() \n\tcar.getNumberOfWheels()");
        car = new SpecialCar();
        System.out.println("Ilość kół: " + car.getNumberOfWheels());


        System.out.println("\n================= KOWARIANTNOSC TABLIC ================");
        System.out.println("\tCar[] arrCar = {new Car(), new Car(), new SpecialCar()}");
        System.out.println("\tSystem.out.println(arrCar.length);");
        Car[] arrCar = {new Car(), new Car(), new SpecialCar()};
        System.out.println("Ilośc aut: " + arrCar.length);


        System.out.println("\n============== AD HOC - PRZECIĄŻANIE METOD ===============");
        System.out.println("\tVehicle vehicleAH = new Car() \n\tVehicle vehicleAH = new Car()");
        Car carAH = new SpecialCar();
        SpecialCar spcCarAH = new SpecialCar();
        System.out.println("carAH.connectionWeight(carAH)");
        carAH.connectionWeight(carAH);//A.m(A)
        System.out.println("carAH.connectionWeight(spcCarAH)");
        carAH.connectionWeight(spcCarAH);//A.m(A)
        System.out.println("pcCarAH.connectionWeight(carAH)");
        spcCarAH.connectionWeight(carAH);//A.m(A)
        System.out.println("spcCarAH.connectionWeight(spcCarAH)");
        spcCarAH.connectionWeight(spcCarAH);//B.m(B)


        System.out.println("\n==================== AD HOC - KOERCJA =====================");
        Integer wi1 = new Integer(5); // pakowanie
        int i1 = wi1.intValue(); // rozpakowanie
        Integer wi2 = 5; // automatyczne pakowanie
        int i2 = wi2; // automatyczne rozp


        System.out.println("\n============== POLIMORFIZM PARAMETRYCZNY ==============");                //można dodać jakies parametry do obieków i zrobić coś ciekawszego
        System.out.println("\tCrash<Car, Vehicle> p = new Crash<Car, Vehicle> (carPR, vehiclePR)");
        Car carPR = new Car();
        SpecialCar scpCarPR = new SpecialCar();

        Crash<SpecialCar, Car> p = new Crash<SpecialCar, Car> (scpCarPR, carPR);
        SpecialCar c = p.getFst();
        Car v = p.getSnd();
        double fullMass = c.getWeight() + v.getWeight();
        System.out.println("Masa stłuczki: " + c.getWeight() + " + " + v.getWeight() + " = " + fullMass);

    }
}
