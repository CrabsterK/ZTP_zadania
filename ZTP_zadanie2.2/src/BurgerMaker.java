public class BurgerMaker {
    public static void main(String[] args) {

        Burger burger1 = new Cheese(new Beef(new BurgerBunWhite()));
        System.out.println("Ingrediens: " + burger1.getDescription());
        System.out.println("Price: " + burger1.getCost());
        System.out.println("Class: " + burger1.getClass());

        System.out.println();

        Burger burger2 = new Pickle(new Cheese(new Beef(new Beef(new BurgerBunSesame()))));
        System.out.println("Ingrediens: " + burger2.getDescription());
        System.out.println("Price: " + burger2.getCost());
        System.out.println("Class: " + burger2.getClass());

        System.out.println();
        System.out.println("=================================");
        System.out.println();




        CloneFactory cloneFactory = new CloneFactory();
        Burger clonedOBb = cloneFactory.getClone(burger1);

        System.out.println("Ingrediens: " + clonedOBb.getDescription());
        System.out.println("Price: " + clonedOBb.getCost());
        System.out.println("Class: " + clonedOBb.getClass());

        System.out.println();
        System.out.println("Object hashcode: " + System.identityHashCode(burger1));
        System.out.println("Cloned hashcode: " + System.identityHashCode(clonedOBb));
    }
}
