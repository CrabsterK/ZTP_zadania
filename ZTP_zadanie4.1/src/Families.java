public class Families extends PartFamily implements Visitable{

    public Families(){

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
