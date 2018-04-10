import java.util.Random;

public class CarOptimal {
    private int mileage;
    private byte age;
    private char color;

    public CarOptimal() {
    }

    public CarOptimal(int mileage, byte age, char color) {
        this.mileage = mileage;
        this.age = age;
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public CarOptimal generateRandom(){
        Random rn = new Random();
        int mil = rn.nextInt(700000);
        byte age = (byte)rn.nextInt(112);
        char color = 'n';

        return new CarOptimal(mil, age, color);
    }
}
