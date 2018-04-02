import java.lang.reflect.InvocationTargetException;

public class Pair<T> implements Cloneable {
    private T genericOb1;
    private T genericOb2;

    public Pair(){
    }

    public T getGenericOb1() {
        return genericOb1;
    }

    public void setGenericOb1(T genericOb1) {
        this.genericOb1 = genericOb1;
    }

    public void setGenericOb2(T genericOb2) {
        this.genericOb2 = genericOb2;
    }

    @Override
    protected Object clone() {
        Pair<T> clone= new Pair<>();
        try{
            clone.genericOb1 = (T) this.genericOb1.getClass().getMethod("clone").invoke(this.genericOb1);
            clone.genericOb2 = (T) this.genericOb2.getClass().getMethod("clone").invoke(this.genericOb2);
        } catch (NoSuchMethodException e) {
            clone.genericOb1 = this.genericOb1;
            clone.genericOb2 = this.genericOb2;
        } catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "genericOb1= [" + genericOb1 +
                "], genericOb2= [" + genericOb2 +
                "]}";
    }
}