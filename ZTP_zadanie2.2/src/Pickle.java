public class Pickle extends ToppingDecoration {

    public Pickle(Burger newBurger) {
        super(newBurger);//from TopicDecorator

        System.out.println("Adding Pickle");
    }

    @Override
    public Burger makeCopy() {
        System.out.println("Pickle is beeing made");
        Pickle pickleOb = null;

        try {
            pickleOb = (Pickle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return pickleOb;
    }

    @Override
    public String getDescription() {
        return tmpBurger.getDescription() + ", Pickle";
    }

    @Override
    public double getCost() {
        return tmpBurger.getCost() + 0.25;
    }
}
