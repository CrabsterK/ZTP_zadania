import java.util.ArrayList;

public class Garage <T> {
    private T t;
    private ArrayList<T> list = new ArrayList<>();


    public void isTheSame(T arg) {
        System.out.println(arg.equals(this));
    }

    public Garage(T e1) {
        t = e1;
        list.add(e1);
    }

    public T getCar() {
        return t;
    }

    //1
    public void addToGarage(T arg) {//
        System.out.println("addToGarage" + arg.getClass());
        list.add(arg);
    }
    public ArrayList< T > getGarageList() {
        return list;
    }

    //2
    public void addListToGarage(ArrayList< T > arg) {
     //   System.out.println("addListToGarage" + arg.getClass());
        list.addAll(arg);
    }

    public ArrayList<? extends T > getExtendsGarageList() {
        return list;
    }

    //3
    public void addExtendsListToGarage(ArrayList<? extends T > arg) {
        //System.out.println("addExtendsListToGarage");
        list.addAll(arg);
    }
    public ArrayList<? super T > getSuperGarageList() {
        return list;
    }

    //4
    public void addSuperListToGarage(ArrayList<? super T > arg) {
      //  System.out.println("addSuperListToGarage");
        //list.addAll(arg);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "t=" + t +
                ", list=" + list +
                '}';
    }
}
