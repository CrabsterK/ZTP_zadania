public class XMLVisitorOut implements Visitor {
    public XMLVisitorOut(){

    }

    @Override
    public String visit(Families familiesItem) {
        return "</families>";
    }

    @Override
    public String visit(Family familyItem) {
        return "</family>";
    }

    @Override
    public String visit(Kid kidItem) {
        return "</kid>";
    }
}
