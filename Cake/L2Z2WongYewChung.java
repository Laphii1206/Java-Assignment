package Cake;

import java.util.*;

public class L2Z2WongYewChung {
    static WongYewChungCake[] cake = new WongYewChungCake[100];
    static Scanner scanner = new Scanner(System.in);
    static String selection;

    public static void mainMenu() {
        while (true) {
            System.out.print("""
                    Menu:
                    1. Add new cake
                    2. Display all cakes
                    Enter selection (0 to quit): """);
            selection = scanner.next();
            System.out.println("");
            switch (selection) {
                case "1":
                    displayCakeMenu();
                    break;
                case "2":
                    WongYewChungCake.showAllCakes(cake);
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Invalid Selection \n");
            }
        }
    }

    public static void displayCakeMenu() {
        String cakeName;
        double kg;
        String[] cakeFlavour = { "Vanilla", "Chocolate", "Pandan", "Strawberry", "Greentea", "Mango", "Banana" };
        System.out.print("Enter Cake name: ");
        cakeName = scanner.next();
        for (int i = 0; i < cakeFlavour.length; i++) {
            System.out.println(i + 1 + ". " + cakeFlavour[i]);
        }
        System.out.print("Enter flavour selection: ");
        selection = scanner.next();
        int selectionNumber = Integer.parseInt(selection);
        if (selectionNumber > cakeFlavour.length || selectionNumber <= 0)
            System.out.println("Invalid Selection");
        else {
            System.out.print("Enter KG: ");
            kg = scanner.nextDouble();
            if (kg > 0)
                WongYewChungCake.makeCake(cake, cakeName, cakeFlavour[selectionNumber - 1], kg);
            else
                System.out.println("Invalid KG \n");
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }

}
