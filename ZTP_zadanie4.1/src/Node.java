import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children;
    private PartFamily value;

    public Node(PartFamily value) {
        children = null;
        this.value = value;
    }

    public Node() {

    }

    private List<Node> getChildrens(){
        return children;
    }

    public void addChild(Node child) {
        if(children == null){
            this.children = new ArrayList<>();
        }
        children.add(child);
    }

    private int numItems(Node t){
        return t.children.size();
    }

    private PartFamily getValue() {
        return value;
    }

    public void printTree(Node t) {
        printIN(t);
        printRec(t);
        printOUT(t);
    }

    private void printRec(Node t) {
        for (int i = 0; i < numItems(t); i++) {
            printIN(t.getChildrens().get(i));
            if (t.getChildrens().get(i).getChildrens() != null) {
                printRec(t.getChildrens().get(i));
            }
            printOUT(t.getChildrens().get(i));
        }
    }

    private void printIN(Node n){
        XMLVisitorIn xmlIn = new XMLVisitorIn();
        System.out.print(n.getValue().accept(xmlIn) + "\n");
    }

    private void printOUT(Node n){
        XMLVisitorOut xmlOut = new XMLVisitorOut();
        System.out.print(n.getValue().accept(xmlOut) + "\n");
    }

    @Override
    public String toString() {
        return value.getName();
    }
}