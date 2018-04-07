import java.util.ArrayList;

public class ArrayListDataHolder <E>{
    ArrayList<E> list;

    public ArrayListDataHolder(ArrayList<E> list) {
        this.list = list;
    }

    public ArrayList<E> getList() {
        return list;
    }
}
