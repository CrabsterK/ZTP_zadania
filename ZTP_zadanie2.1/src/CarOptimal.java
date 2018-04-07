import java.util.Random;

public class CarOptimal{
    private long mileage;
    private long age;
    private String color;

    public CarOptimal() {
    }

    public CarOptimal(long mileage, long age, String color) {
        this.mileage = mileage;
        this.age = age;
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public CarOptimal generateRandom(){
        Random rn = new Random();
        long mil = rn.nextInt(700000);
        long age = rn.nextInt(65);
        String color = "color";

        return new CarOptimal(mil, age, color);
    }
}