public class Car extends Vehicle {
    private int numberOfWheels = 4;
    private int weight = 1300;

    public int getNumberOfWheels(){
        return numberOfWheels;
    }

    public double getWeight(){
        return weight;
    }

    public void connectionWeight(Car car){
        System.out.println(weight + " + " + car.weight + " = " + String.valueOf(weight + car.weight));
    }
}
