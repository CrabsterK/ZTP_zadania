public class BurgerBunWhite implements Burger {

    public BurgerBunWhite(){
        System.out.println("BurgerBunWhite is made");
    }
    @Override
    public Burger makeCopy() {
        System.out.println("BurgerBunWhite is beeing made");
        BurgerBunWhite whiteOb = null;

        try {
            whiteOb = (BurgerBunWhite) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return whiteOb;
    }

    @Override
    public String getDescription() {
        return "White bun";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}
