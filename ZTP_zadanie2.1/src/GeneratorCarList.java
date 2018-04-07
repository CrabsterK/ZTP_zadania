import java.util.ArrayList;

public class GeneratorCarList {

    public GeneratorCarList() {
    }

    public ArrayDataHolder<CarSuboptimal> generateArrSobCar(int quantity){
        CarSuboptimal[] list = new CarSuboptimal[quantity];
        CarSuboptimal soCar = new CarSuboptimal();
        for(int i = 0; i < quantity; i++){
            list[i] = soCar.generateRandom();
        }
        return new ArrayDataHolder(list);
    }

    public ArrayDataHolder<CarOptimal> generateArrOptCar(int quantity){
        CarOptimal[] list = new CarOptimal[quantity];
        CarOptimal optCar = new CarOptimal();
        for(int i = 0; i < quantity; i++){
            list[i] = optCar.generateRandom();
        }
        return new ArrayDataHolder(list);
    }

    public ArrayListDataHolder<CarSuboptimal> generateListSobCar(int quantity){
        ArrayList<CarSuboptimal> list = new ArrayList<CarSuboptimal>();
        CarSuboptimal soCar = new CarSuboptimal();
        for(int i = 0; i < quantity; i++){
            list.add(soCar.generateRandom());
        }
        return new ArrayListDataHolder(list);
    }

    public ArrayListDataHolder<CarOptimal> generateListOptCar(int quantity ){
        ArrayList<CarOptimal> list = new ArrayList<CarOptimal>();
        CarOptimal optCar = new CarOptimal();
        for(int i = 0; i < quantity; i++){
            list.add(optCar.generateRandom());
        }
        return new ArrayListDataHolder(list);
    }
}
