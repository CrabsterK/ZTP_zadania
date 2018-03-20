public class Crash <A, B> {
    private A ob1;
    private B ob2;

    public Crash(A ob1, B ob2) {
        this.ob1 = ob1; this.ob2 = ob2;
    }

    public A getFst() {
        return ob1;
    }

    public B getSnd() {
        return ob2;
    }
    public String toString() {
        return "Crash between: " + ob1 + " and " + ob2;
    }
}
