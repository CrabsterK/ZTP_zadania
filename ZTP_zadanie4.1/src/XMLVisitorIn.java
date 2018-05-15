public class XMLVisitorIn implements Visitor {
    public XMLVisitorIn(){

    }

    @Override
    public String visit(Families familiesItem) {
        return "<families>";
    }

    @Override
    public String visit(Family familyItem) {
        return "<family>\n"
                + "\t<name>" + familyItem.getName() + "</name>";
    }

    @Override
    public String visit(Kid kidItem) {
        return "<kid>\n"
                + "\t<name>" + kidItem.getName() + "</name>";
    }
}
