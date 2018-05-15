public class Family extends PartFamily implements Visitable{
    private String name;

    public Family(String name){
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
