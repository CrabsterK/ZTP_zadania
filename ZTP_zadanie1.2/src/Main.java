public class Main {
/*
*   Refleksja- przekazanie informacji o typach w czasie wykonania
*/
    public static final int PAIR_ARRAY_SIZE = 4;
    public static void main(String[] args){

        try {
            //create generic objects
            Pair stringPair = Pair.class.newInstance();
            Pair booleanPair = Pair.class.newInstance();
            Pair intPair = Pair.class.newInstance();
            Pair doublePair = Pair.class.newInstance();

            System.out.println("Created Pair object: " + stringPair.getClass().toString());

            stringPair.setGenericOb1("Fst");
            stringPair.setGenericOb2("Snd");
            System.out.println("Created generic object in Pair of string: " + stringPair.getGenericOb1().getClass().toString() + "\n");

            booleanPair.setGenericOb1(true);
            booleanPair.setGenericOb2(false);

            intPair.setGenericOb1(1994);
            intPair.setGenericOb2(1852);

            doublePair.setGenericOb1(1.36);
            doublePair.setGenericOb2(6.28);


            //create generic array
            Pair[] arr = new Pair[PAIR_ARRAY_SIZE];
            arr[0] = stringPair;
            arr[1] = booleanPair;
            arr[2] = intPair;
            arr[3] = doublePair;


            System.out.println("=====GENERIC ARRAY=====");
            for(int i = 0; i < PAIR_ARRAY_SIZE; i++){
                System.out.printf("Generic type: " + arr[i].getGenericOb1().getClass().toString() + "\t" + "Values: " + arr[i].toString() + "\n");
            }


            System.out.println("\n========CLONING========");

            Pair clStringPair = (Pair) stringPair.clone();
            Pair clBooleanPair = (Pair) booleanPair.clone();
            Pair clIntPair = (Pair) intPair.clone();
            Pair clDoublePair = (Pair) doublePair.clone();

            System.out.println("Original: " + stringPair.toString() + "\t Clone: " + clStringPair.toString());
            System.out.println("Original: " + booleanPair.toString() + "\t Clone: " + clBooleanPair.toString());
            System.out.println("Original: " + intPair.toString() + "\t Clone: " + clIntPair.toString());
            System.out.println("Original: " + doublePair.toString() + "\t Clone: " + clDoublePair.toString());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}