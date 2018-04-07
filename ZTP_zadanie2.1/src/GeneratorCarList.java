import java.util.ArrayList;

public class GeneratorCarList {

    public GeneratorCarList() {
    }

    public ArrayDataHolder generateArrSobCar(int quantity){
        CarSuboptimal[] list = new CarSuboptimal[quantity];
        CarSuboptimal soCar = new CarSuboptimal();
        for(int i = 0; i < quantity; i++){
            list[i] = soCar.generateRandom();
        }
        return new ArrayDataHolder(list);
    }

    public ArrayDataHolder generateArrOptCar(int quantity){
        CarOptimal[] list = new CarOptimal[quantity];
        CarOptimal optCar = new CarOptimal();
        for(int i = 0; i < quantity; i++){
            list[i] = optCar.generateRandom();
        }
        return new ArrayDataHolder(list);
    }

    public ArrayListDataHolder generateListSobCar(int quantity){
        ArrayList<Object> list = new ArrayList<Object>();
        CarSuboptimal soCar = new CarSuboptimal();
        for(int i = 0; i < quantity; i++){
            list.add(soCar.generateRandom());
        }
        return new ArrayListDataHolder(list);
    }

    public ArrayListDataHolder generateListOptCar(int quantity ){
        ArrayList<Object> list = new ArrayList<Object>();
        CarOptimal optCar = new CarOptimal();
        for(int i = 0; i < quantity; i++){
            list.add(optCar.generateRandom());
        }
        return new ArrayListDataHolder(list);
    }
}
