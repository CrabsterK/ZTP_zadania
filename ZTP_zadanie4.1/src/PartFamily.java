public abstract class PartFamily implements Visitable{
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public abstract String accept(Visitor visitor);
}
