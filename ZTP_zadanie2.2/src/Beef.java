public class Beef extends ToppingDecoration {

    public Beef(Burger newBurger) {
        super(newBurger);//from TopicDecorator (supertype)

        System.out.println("Adding Bun");
        System.out.println("Adding Beef");
    }

    @Override
    public Burger makeCopy() {
        System.out.println("Beef is beeing made");
        Beef beefOb = null;

        try {
            beefOb = (Beef) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return beefOb;
    }

    @Override
    public String getDescription() {
        return tmpBurger.getDescription() + ", Beef";
    }

    @Override
    public double getCost() {
        return tmpBurger.getCost() + 0.50;
    }
}
