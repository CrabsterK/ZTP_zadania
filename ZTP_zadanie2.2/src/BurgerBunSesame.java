public class BurgerBunSesame implements Burger {

    @Override
    public Burger makeCopy() {
        System.out.println("BurgerBunSesame is beeing made");
        BurgerBunSesame sesameOb = null;

        try {
            sesameOb = (BurgerBunSesame) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sesameOb;
    }

    @Override
    public String getDescription() {
        return "Sesame bun";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}
