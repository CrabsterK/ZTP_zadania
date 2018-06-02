public class Vehicle implements Runnable {
    private final int ID;
    Garage garage;
    int parkedTime;

    public Vehicle(Garage garage, int ID, int parkedTime) {
        this.garage = garage;
        this.ID = ID;
        this.parkedTime = parkedTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("Podjechał " + ID);
            garage.arrive(ID); // go sleep after come from arrive, where it waits for place in garage

            Thread.sleep(parkedTime);

            garage.leave(ID);
            System.out.println("Wyjechał " + ID);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
