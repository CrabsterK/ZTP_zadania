import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        final int EXPERIMENT_COUNTER = 10;
       GeneratorCarList carGenerator = new GeneratorCarList();
        long startTime;
        long estimatedTime;

        System.out.println("====== OPTYMALIZACJA ======");
        System.out.println("OBIEKT \tLISTA \tCZAS (mediana z " + EXPERIMENT_COUNTER + " prób)");


        ArrayList arrTT = new ArrayList();
        for(int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTime = System.currentTimeMillis();
            carGenerator.generateArr(1000000, true);
            estimatedTime = System.currentTimeMillis() - startTime;
            arrTT.add((double)estimatedTime);
        }
        System.out.println("TAK \tTAK \t" + getMedian(arrTT) + "ms");


        ArrayList arrNT = new ArrayList();
        for(int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTime = System.currentTimeMillis();
            carGenerator.generateArr(1000000, false);
            estimatedTime = System.currentTimeMillis() - startTime;
            arrNT.add((double)estimatedTime);
        }
        System.out.println("NIE \tTAK \t" + getMedian(arrNT) + "ms");


        ArrayList arrTN = new ArrayList();
        for(int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTime = System.currentTimeMillis();
            carGenerator.generateList(1000000, true);
            estimatedTime = System.currentTimeMillis() - startTime;
            arrTN.add((double)estimatedTime);
        }
        System.out.println("TAK \tNIE \t" + getMedian(arrTN) + "ms");


        ArrayList arrNN = new ArrayList();
        for(int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTime = System.currentTimeMillis();
            carGenerator.generateList(1000000, false);
            estimatedTime = System.currentTimeMillis() - startTime;
            arrNN.add((double)estimatedTime);
        }
        System.out.println("NIE \tNIE \t" + getMedian(arrNN) + "ms");






        /*carGenerator.generateArr(1000, true);
        carGenerator.generateArr(10000, true);
        carGenerator.generateArr(100000, true);

        carGenerator.generateArr(1000, false);
        carGenerator.generateArr(10000, false);
        carGenerator.generateArr(100000, false);


        carGenerator.generateList(1000, true);
        carGenerator.generateList(10000, true);
        carGenerator.generateList(100000, true);

        carGenerator.generateList(1000, false);
        carGenerator.generateList(10000, false);
        carGenerator.generateList(100000, false);*/
    }

    public static double getMedian(ArrayList set) {
        Collections.sort(set);
        int middle = set.size() / 2;
        middle = middle % 2 == 0? middle - 1 : middle;
        return (double) set.get(middle);
    }
}
