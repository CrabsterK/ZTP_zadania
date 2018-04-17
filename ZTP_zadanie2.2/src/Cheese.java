public class Cheese extends ToppingDecoration {

    public Cheese(Burger newBurger) {
        super(newBurger);//from TopicDecorator

        System.out.println("Adding Cheese");
    }

    @Override
    public Burger makeCopy() {
        System.out.println("Cheese is beeing made");
        Cheese cheeseOb = null;

        try {
            cheeseOb = (Cheese) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cheeseOb;
    }

    @Override
    public String getDescription() {
        return tmpBurger.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return tmpBurger.getCost() + 0.20;
    }
}
