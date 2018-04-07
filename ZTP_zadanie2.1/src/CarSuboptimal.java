import java.util.Random;

public class CarSuboptimal{
    private int mileage;
    private byte age;
    private char color;

    public CarSuboptimal() {
    }

    public CarSuboptimal(int mileage, byte age, char color) {
        this.mileage = mileage;
        this.age = age;
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public CarSuboptimal generateRandom(){
        Random rn = new Random();
        int mil = rn.nextInt(700000);
        byte age = (byte)rn.nextInt(112);
        char color = 'n';

        return new CarSuboptimal(mil, age, color);
    }
}
