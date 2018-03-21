//Klasa FrontalCrash rozszerza funkcjonalność klasy Crash
// o możliwość zastępowania obiektów w istniejącej parze.

public class FrontalCrash <A, B> extends Crash <A, B> {
    private A e1;
    private B e2;

    public FrontalCrash(A e1, B e2) {
        super(e1, e2);
    }
    public void setFst(A e) {
        e1 = e;
    }
    public void setSnd(B e) {
        e2 = e;
    }



}
