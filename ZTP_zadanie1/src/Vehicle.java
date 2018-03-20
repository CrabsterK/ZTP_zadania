public class Vehicle {
    private int weight = 50;
    public int getNumberOfWheels(){
        return 0;
    }

    public double getWeight(){
        return 100;
    }

    public void connectionWeight(Vehicle vehicle){
        System.out.println(weight + " + " + vehicle.weight + " = " + String.valueOf(weight + vehicle.weight));
    }
}
