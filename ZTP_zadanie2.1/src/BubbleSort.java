import java.util.ArrayList;

public class BubbleSort {

    public void sortArray(CarOptimal[] x) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = 1; i < x.length; i++) {
                CarOptimal temp;
                if(x[i-1].getMileage() > x[i].getMileage()) {
                    temp = x[i-1];
                    x[i-1] = x[i];
                    x[i] = temp;
                    swapped = true;
                }
            }
        }
    }

    public void sortArray(CarSuboptimal[] x) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = 1; i < x.length; i++) {
                CarSuboptimal temp;
                if(x[i-1].getMileage() > x[i].getMileage()) {
                    temp = x[i-1];
                    x[i-1] = x[i];
                    x[i] = temp;
                    swapped = true;
                }
            }
        }
    }

    public void sortList(ArrayList<CarOptimal> x) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = 1; i < x.size(); i++) {
                CarOptimal temp;
                if(x.get(i-1).getMileage() > x.get(i).getMileage()) {
                    temp = x.get(i-1);
                    x.set(i-1, x.get(i));
                    x.set(i, temp);
                    swapped = true;
                }
            }
        }
    }

    public void sortList2(ArrayList<CarSuboptimal> x) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = 1; i < x.size(); i++) {
                CarSuboptimal temp;
                if(x.get(i-1).getMileage() > x.get(i).getMileage()) {
                    temp = x.get(i-1);
                    x.set(i-1, x.get(i));
                    x.set(i, temp);
                    swapped = true;
                }
            }
        }
    }
}