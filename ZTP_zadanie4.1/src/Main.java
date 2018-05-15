public class Main {
    public static void main(String[] args) {
        Families families = new Families();
        Family family1 = new Family("Nowak");
        Family family2 = new Family("Kowalski");
        Kid kid1 = new Kid("Arek");
        Kid kid2 = new Kid("Patryk");
        Kid kid3 = new Kid("Marta");
        Kid kid4 = new Kid("Patrycja");
        Kid kid5 = new Kid("Ania");

        Node familyNode1 = new Node(family1);
        Node familyNode2 = new Node(family2);
        Node kidNode1 = new Node(kid1);
        Node kidNode2 = new Node(kid2);
        Node kidNode3 = new Node(kid3);
        Node kidNode4 = new Node(kid4);
        Node kidNode5 = new Node(kid5);


        Node root = new Node(families);
        root.addChild(familyNode1);
        root.addChild(familyNode2);
        familyNode1.addChild(kidNode1);
        familyNode1.addChild(kidNode2);
        familyNode2.addChild(kidNode3);
        familyNode2.addChild(kidNode4);
        familyNode2.addChild(kidNode5);


        Node no = new Node();
        no.printTree(root);
    }
}
