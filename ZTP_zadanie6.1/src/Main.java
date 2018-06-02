public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int GARAGE_SIZE = 5;
        final int AMOUNT_VEHICLES = 25;
        final int CAR_ARRIVED_DELAY = 100; // ms
        final int PARKED_TIME = 3000; // ms

        Garage garage = new Garage(GARAGE_SIZE);
        for (int i = 0; i < AMOUNT_VEHICLES; i++){
            Thread veh = new Thread(new Vehicle(garage, i + 1, PARKED_TIME));
            Thread.sleep(CAR_ARRIVED_DELAY);
            veh.start();
        }
    }
}
