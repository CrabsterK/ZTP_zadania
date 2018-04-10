import java.util.ArrayList;

public class GeneratorCarList {

    public GeneratorCarList() {
    }

    public ArrayDataHolder<CarOptimal> generateArrOptCar(int quantity){
        CarOptimal[] list = new CarOptimal[quantity];
        CarOptimal car = new CarOptimal();
        for(int i = 0; i < quantity; i++){
            list[i] = car.generateRandom();
        }
        return new ArrayDataHolder(list);
    }

    public ArrayDataHolder<CarSubOpt> generateArrSobCar(int quantity){
        CarSubOpt[] list = new CarSubOpt[quantity];
        CarSubOpt car = new CarSubOpt();
        for(int i = 0; i < quantity; i++){
            list[i] = car.generateRandom();
        }
        return new ArrayDataHolder(list);
    }

    public ArrayListDataHolder<CarOptimal> generateListOptCar(int quantity){
        ArrayList<CarOptimal> list = new ArrayList<CarOptimal>();
        CarOptimal car = new CarOptimal();
        for(int i = 0; i < quantity; i++){
            list.add(car.generateRandom());
        }
        return new ArrayListDataHolder(list);
    }

    public ArrayListDataHolder<CarSubOpt> generateListSobCar(int quantity ){
        ArrayList<CarSubOpt> list = new ArrayList<CarSubOpt>();
        CarSubOpt car = new CarSubOpt();
        for(int i = 0; i < quantity; i++){
            list.add(car.generateRandom());
        }
        return new ArrayListDataHolder(list);
    }
}
