public class SpecialCar extends Car {
    private int numberOfWheels = 5;
    private int weight = 1800;

    public SpecialCar(){

    }

    public SpecialCar(int weight){
        this.weight = weight;
    }

    public int getNumberOfWheels(){
        return numberOfWheels;
    }

    public double getWeight(){
        return weight;
    }

    public void connectionWeight(SpecialCar specialCar){
        System.out.println(weight + " + " + specialCar.weight + " = " + String.valueOf(weight + specialCar.weight));
    }
}
