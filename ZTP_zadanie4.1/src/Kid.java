public class Kid extends PartFamily implements Visitable{
    private String name;

    public Kid(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
