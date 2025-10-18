public class PrjF1G8Item {
    private String name;
    private double size;

    PrjF1G8Item(String n, double s) {
        this.name = n;
        this.size = s;
    }

    public double getSize() {
        return size;
    }

    public String toString() {
        return name + "(" + size + "cm3)";
    }
}