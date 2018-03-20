public class Color {
    private String color;

    public Color(String color){
        this.color = color;
    }
    public String stringValue(){
        return color;
    }

    //public static operator== Color(String color) {    //u cant overrite operators in java
    //    return new Color(color);
    //}
}
