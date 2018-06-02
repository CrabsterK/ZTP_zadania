import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int garageSlots;
    private final int GARAGESIZE;
    private List<Integer> vehicles;

    public Garage(int n) {
        garageSlots = n;
        GARAGESIZE = n;
        vehicles = new ArrayList<>();
    }

    synchronized void arrive(Integer vehicle) throws InterruptedException {
        while(garageSlots == 0) {
            wait();
        }
        garageSlots--;
        vehicles.add(vehicle);
        printSlots();
    }

    synchronized void leave(Integer vehicle) {
        vehicles.remove(vehicle);
        notify();
        garageSlots++;
    }

    public void printSlots() {
        StringBuilder sb = new StringBuilder();
        sb.append("GARAŻ: \t");
        sb.append(" | ");
        for(int i : vehicles){
            sb.append(i + " | ");
        }
        int emptySlots = GARAGESIZE - vehicles.size() ;
        for(int i = 0; i < emptySlots; i++){
            sb.append(" " + " | ");
        }
        System.out.println(sb.toString());
        System.out.println();
    }
}