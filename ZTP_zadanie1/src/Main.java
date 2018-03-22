import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n================ POLIMORFIZM INKLUZYJNY ================");// dziedziczenie nadpissanie
        System.out.println("\tCar car = new Car(); \n\tcar.getNumberOfWheels()");
        Car car = new Car();
        System.out.println("Ilość kół: " + car.getNumberOfWheels());
        System.out.println("\tcar = new SpecialCar() \n\tcar.getNumberOfWheels()");
        car = new SpecialCar();
        System.out.println("Ilość kół: " + car.getNumberOfWheels());


        System.out.println("\n================= KOWARIANTNOSC TABLIC =================");
        System.out.println("\tCar[] arrCar = {new Car(), new Car(), new SpecialCar()}");
        System.out.println("\tSystem.out.println(arrCar.length);");
        Car[] arrCar = {new Car(), new Car(), new SpecialCar()};
        System.out.println("Ilośc aut: " + arrCar.length);


        System.out.println("\n============= AD HOC - PRZECIĄŻANIE METOD ==============");
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


        //System.out.println("\n================== AD HOC - KOERCJA ====================");
        Integer wi1 = new Integer(5); // pakowanie
        int i1 = wi1.intValue(); // rozpakowanie
        Integer wi2 = 5; // automatyczne pakowanie
        int i2 = wi2; // automatyczne rozp


        System.out.println("\n============== POLIMORFIZM PARAMETRYCZNY ===============");                //można dodać jakies parametry do obieków i zrobić coś ciekawszego
        System.out.println("\tCrash<Car, Vehicle> p = new Crash<Car, Vehicle> (carPR, vehiclePR)");
        Car carPR = new Car();
        SpecialCar scpCarPR = new SpecialCar();

        Crash<SpecialCar, Car> p = new Crash<SpecialCar, Car> (scpCarPR, carPR);
        SpecialCar c = p.getFst();
        Car v = p.getSnd();
        double fullMass = c.getWeight() + v.getWeight();
        System.out.println("Masa stłuczki: " + c.getWeight() + " + " + v.getWeight() + " = " + fullMass);





        System.out.println("\n============== POLIMORFIZM OGRANICZENIOWY ==============");


        ArrayList<Car> l1 = new ArrayList<>();
        l1.add(new Car());
        l1.add(new SpecialCar());

        System.out.println("~Bezpieczny odczyt~");
        ArrayList<? extends Vehicle> l2 = l1;
        //l1.add(new Vehicle());  //błąd kompilacji (nie wiadomo, jakiego typu elementy na liście)
        Vehicle vehicleOGR = l2.get(0);//Bezpieczne odczyty (na pewno dzieci Vehicle)
        System.out.println(l2.get(1).getClass()); // class SpecialCar




        System.out.println("\n~Bezpieczny zapis~");
        //Nie da się określić typu wartości na liście, dlatego kompilator zabrania odczytów, czego innego niż Object
        ArrayList<Vehicle> li1 = new ArrayList<Vehicle>();
        li1.add(new Vehicle());
        li1.add(new Car());

        ArrayList<? super SpecialCar> li2 = li1;
        li2.add(new SpecialCar());
        //li2.add(new Car());                     //błąd kompilacji (bezpośrednio można wstawiać tylko SpecialCar)
        //SpecialCar specianCarZap = li2.get(0);   //błąd kompilacji – nie ma gwarancji, że tam jest SpecialCar
        Object obZapi = li2.get(0);             //OK. – na pewno tam jest co najmniej Object
        System.out.println(li2.get(0).getClass()); // class Vehicle




        System.out.println("\n=====TESTY WYWOLAN=====");
        Car carLast = new Car();
        Garage<Car> gar = new Garage<>(carLast);


        Vehicle vehLast = new Vehicle();
        SpecialCar spcaLast = new SpecialCar();
        ArrayList<Vehicle> listVehLast= new ArrayList<Vehicle>();
        listVehLast.add(vehLast);
        ArrayList<Car> listCarLast= new ArrayList<Car>();
        listCarLast.add(carLast);
        ArrayList<SpecialCar> listSpecLast= new ArrayList<SpecialCar>();
        listSpecLast.add(spcaLast);



        //1
        //gar.addToGarage(vehLast);//tego już nie można
        gar.addToGarage(carLast);
        gar.addToGarage(spcaLast);

        System.out.println(gar.getCar());

        //2
        //gar.addListToGarage(listVehLast);
        gar.addListToGarage(listCarLast);
        //gar.addListToGarage(listSpecLast);

        System.out.println(gar.getGarageList());

        //3
       // gar.addExtendsListToGarage(listVehLast);
        gar.addExtendsListToGarage(listCarLast);
        gar.addExtendsListToGarage(listSpecLast);

        System.out.println(gar.getExtendsGarageList());

        //4
        gar.addSuperListToGarage(listVehLast);
        gar.addSuperListToGarage(listCarLast);
        //gar.addSuperListToGarage(listSpecLast);

        System.out.println(gar.getSuperGarageList());



        //System.out.println("gar.getGarageList() :    " + gar.getGarageList());







    }
}
