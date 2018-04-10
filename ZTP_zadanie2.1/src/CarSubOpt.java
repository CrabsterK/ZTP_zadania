import java.util.Random;

public class CarSubOpt {
    private long mileage;
    private long age;
    private String color;

    public CarSubOpt() {
    }

    public CarSubOpt(long mileage, long age, String color) {
        this.mileage = mileage;
        this.age = age;
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public CarSubOpt generateRandom(){
        Random rn = new Random();
        long mil = rn.nextInt(700000);
        long age = rn.nextInt(65);
        String color = "color";

        return new CarSubOpt(mil, age, color);
    }
}