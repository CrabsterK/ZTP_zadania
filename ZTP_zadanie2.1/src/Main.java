import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        final int EXPERIMENT_COUNTER = 10;
        final int LIST_TO_USE = 10000;
        GeneratorCarList carGenerator = new GeneratorCarList();
        BubbleSort bt = new BubbleSort();
        long startTimeGenerate;
        long startTimeSort;
        long estimatedTimeGenerate;
        long estimatedTimeSort;


        System.out.println("====== GENEROWANIE LIST OBIEKTÓW/SORTOWANIE ======");
        System.out.println("OBIEKT \tLISTA \tCZAS GENEROWANIA \tCZAS SORTOWANIA (mediana z " + EXPERIMENT_COUNTER + " prób, wielkość list: " + LIST_TO_USE +")");


        ArrayList arrTT = new ArrayList();
        ArrayList arrSortTT = new ArrayList();
        for (int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTimeGenerate = System.nanoTime();
            CarOptimal[] list = carGenerator.generateArrOptCar(LIST_TO_USE).getList();
            estimatedTimeGenerate = System.nanoTime() - startTimeGenerate;
            startTimeSort = System.currentTimeMillis();
            bt.sortArray(list);
            estimatedTimeSort = System.currentTimeMillis() - startTimeSort;
            arrTT.add((double) estimatedTimeGenerate);
            arrSortTT.add((double) estimatedTimeSort);
        }
        System.out.println("TAK \tTAK \t" + getMedian(arrTT)/1000 + "µs \t\t\t" + getMedian(arrSortTT) + "ms");


        ArrayList arrNT = new ArrayList();
        ArrayList arrSortNT = new ArrayList();
        for (int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTimeGenerate = System.nanoTime();
            CarSuboptimal[] list = carGenerator.generateArrSobCar(LIST_TO_USE).getList();
            estimatedTimeGenerate = System.nanoTime() - startTimeGenerate;
            startTimeSort = System.currentTimeMillis();
            bt.sortArray(list);
            estimatedTimeSort = System.currentTimeMillis() - startTimeSort;
            arrNT.add((double) estimatedTimeGenerate);
            arrSortNT.add((double) estimatedTimeSort);
        }
        System.out.println("NIE \tTAK \t" + getMedian(arrNT)/1000 + "µs \t\t\t" + getMedian(arrSortNT) + "ms");


        ArrayList arrTN = new ArrayList();
        ArrayList arrSortTN = new ArrayList();
        for (int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTimeGenerate = System.nanoTime();
            ArrayList list = carGenerator.generateListOptCar(LIST_TO_USE).getList();
            estimatedTimeGenerate = System.nanoTime() - startTimeGenerate;
            startTimeSort = System.currentTimeMillis();
            bt.sortList(list);
            estimatedTimeSort = System.currentTimeMillis() - startTimeSort;
            arrTN.add((double) estimatedTimeGenerate);
            arrSortTN.add((double) estimatedTimeSort);
        }
        System.out.println("TAK \tNIE \t" + getMedian(arrTN)/1000 + "µs \t\t\t" + getMedian(arrSortTN) + "ms");


        ArrayList arrNN = new ArrayList();
        ArrayList arrSortNN = new ArrayList();
        for (int i = 0; i < EXPERIMENT_COUNTER; i++) {
            startTimeGenerate = System.nanoTime();
            ArrayList list = carGenerator.generateListSobCar(LIST_TO_USE).getList();
            estimatedTimeGenerate = System.nanoTime() - startTimeGenerate;
            startTimeSort = System.currentTimeMillis();
            bt.sortList2(list);
            estimatedTimeSort = System.currentTimeMillis() - startTimeSort;
            arrNN.add((double) estimatedTimeGenerate);
            arrSortNN.add((double) estimatedTimeSort);
        }
        System.out.println("NIE \tNIE \t" + getMedian(arrNN)/1000 + "µs \t\t\t" + getMedian(arrSortNN) + "ms");
    }


    public static double getMedian(ArrayList set) {
        Collections.sort(set);
        int middle = set.size() / 2;
        middle = middle % 2 == 0? middle - 1 : middle;
        return (double) set.get(middle);
    }
}
