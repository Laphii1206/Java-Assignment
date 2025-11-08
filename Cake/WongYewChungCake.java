package Cake;

public class WongYewChungCake {
    // 1 kg to rm 28
    String nameCake, cakeFlavour;
    double kg;
    static int count = 0;
    static double price = 28;

    public WongYewChungCake(String nameCake, String cakeFlavour, double kg) {
        this.nameCake = nameCake;
        this.cakeFlavour = cakeFlavour;
        this.kg = kg;
    }

    public String toString() {
        return nameCake + " " + cakeFlavour + " " + kg + " " + price * kg;
    }

    public static void makeCake(WongYewChungCake[] cake, String cakeName, String cakeFlavour, double kg) {
        WongYewChungCake newCake = new WongYewChungCake(cakeName, cakeFlavour,
                kg);
        cake[count] = newCake;
        count++;
    }

    public static void showAllCakes(WongYewChungCake[] cake) {
        System.out.println("Name \t Flavor \t KG \t Price");
        for (int i = 0; i < count; i++) {
            System.out.println(cake[i]);
        }
        System.out.println("");
    }

}
