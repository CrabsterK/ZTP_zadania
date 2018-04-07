import java.util.ArrayList;

public class GeneratorCarList {

    public GeneratorCarList() {
    }

    public ArrayDataHolder generateArr(int quantity, boolean optimalCar){
        Object[] list = new Object[quantity];

        if(optimalCar == false){
            CarSuboptimal soCar = new CarSuboptimal();
            for(int i = 0; i < quantity; i++){
                list[i] = soCar.generateRandom();
            }
        }

        if(optimalCar == true){
            CarOptimal optCar = new CarOptimal();
            for(int i = 0; i < quantity; i++){
                list[i] = optCar.generateRandom();
            }
        }
        return new ArrayDataHolder(list);
    }

    public ArrayListDataHolder generateList(int quantity, boolean optimalCar){
        ArrayList<Object> list = new ArrayList<Object>();

        if(optimalCar == false){
            CarSuboptimal soCar = new CarSuboptimal();
            for(int i = 0; i < quantity; i++){
                list.add(soCar.generateRandom());
            }
        }

        if(optimalCar == true){
            CarOptimal optCar = new CarOptimal();
            for(int i = 0; i < quantity; i++){
                list.add(optCar.generateRandom());
            }
        }
        return new ArrayListDataHolder(list);
    }
}
