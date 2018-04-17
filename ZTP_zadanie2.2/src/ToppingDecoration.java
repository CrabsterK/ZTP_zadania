public abstract class ToppingDecoration implements Burger {

    protected Burger tmpBurger;

    public ToppingDecoration(Burger newBurger) {
        this.tmpBurger = newBurger;
    }

    @Override
    public String getDescription() {
        return tmpBurger.getDescription();
    }

    @Override
    public double getCost() {
        return tmpBurger.getCost();
    }
}
