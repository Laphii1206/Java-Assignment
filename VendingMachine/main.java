package VendingMachine;

import java.util.Scanner;

public class main {

    public class LabF1WongYewChung {
        static Scanner scanner = new Scanner(System.in);
        static double balance = 0, total = 0, amount = 0;
        static String item;
        static String receipt = "";

        public static void main(String[] args) {
            char selection;
            do {
                printItem();
                insertBalance();
                purchaseItem();
                printReceipt();
                System.out.print("Next Customer? (y/n): ");
                selection = scanner.next().charAt(0);
                if (selection != 'y' && selection != 'Y') {
                    System.out.println("Thank you for using the vending machine!");
                } else if (selection != 'n' && selection != 'N' && selection != 'y' &&
                        selection != 'Y') {
                    System.out.println("Invalid selection. Please enter 'y' or 'n'.");
                }
            } while (selection != 'n' && selection != 'N');
        }

        public static void printItem() {
            System.out.println("Item \t\t\t Price(RM)");
            System.out.println("1.Coca-cola\t\t 1.80");
            System.out.println("2.Mineral water\t\t 1.00");
            System.out.println("3.Soybean\t\t 2.00");
            System.out.println("4.Nescafe Coffee\t 3.50");
            System.out.println("5.Potato Chips\t\t 3.80");
            System.out.println("6.Snickers \t\t 4.20");
            System.out.println("7.Twisties \t\t 0.80");
        }

        public static void insertBalance() {
            System.out.print("Please Insert Your Balance: RM");
            amount = scanner.nextDouble();
            while (amount <= 0.8) {
                System.out.println("Invalid Balance or less than 0.80 for minimum purchase Please Try Again");
                System.out.print("Please Insert Your Balance: RM");
                amount = scanner.nextDouble();
            }
            balance = amount;
        }

        public static void showAffordableItem(double balance) {
            System.out.printf("\nYou Currently have RM %.2f left to spend\n", balance);
            System.out.println("Affordable items Are:");
            System.out.println("Item \t\t\t Price(RM)");
            if (balance >= 1.80)
                System.out.println("1.Coca-cola \t\t 1.80");
            if (balance >= 1.00)
                System.out.println("2.Mineral water\t\t 1.00");
            if (balance >= 2.00)
                System.out.println("3.Soybean \t\t 2.00");
            if (balance >= 3.50)
                System.out.println("4.Nescafe Coffee\t 3.50");
            if (balance >= 3.80)
                System.out.println("5.Potato Chips \t\t 3.80");
            if (balance >= 4.20)
                System.out.println("6.Snickers \t\t 4.20");
            if (balance >= 0.80)
                System.out.println("7.Twisties \t\t 0.80");
        }

        public static void purchaseItem() {
            double price;
            int selection;
            do {
                showAffordableItem(balance);
                System.out.print("Please Select Item to Purchase (0 to exit): ");
                selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        item = "Coca-cola";
                        price = 1.80;
                        break;
                    case 2:
                        item = "Mineral water";
                        price = 1.00;
                        break;
                    case 3:
                        item = "Soybean\t";
                        price = 2.00;
                        break;
                    case 4:
                        item = "Nescafe Coffee";
                        price = 3.50;
                        break;
                    case 5:
                        item = "Potato Chips";
                        price = 3.80;
                        break;
                    case 6:
                        item = "Snickers";
                        price = 4.20;
                        break;
                    case 7:
                        item = "Twisties";
                        price = 0.80;
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid Selection");
                        price = -1;
                        break;
                }
                if (price > balance) {
                    System.out.println("You have selected item outside of affordable range please try again");
                } else if (balance > price && price >= 0) {
                    total += price;
                    balance -= price;
                    receipt += item + "\t" + price + "\n";
                    System.out.println("You have purchased " + item + " for RM " + price);
                }
                if (balance < 0.8) {
                    System.out.println("You have sufficient balance to make a minimum purchase.");
                }
            } while (balance >= 0.79 && selection != 0);
        }

        public static void printReceipt() {
            if (total == 0) {
                System.out.println("No items purchased");
            } else {
                System.out.println("\nReceipt");
                System.out.println("-------------------------");
                System.out.println(receipt);
                System.out.println("-------------------------");
                System.out.println("Total\t\t" + total);
                System.out.println("==========================");
                System.out.println("Amount inserted\t" + amount);
                System.out.printf("Balance\t\t%.2f\n", balance);
            }
            receipt = "";
            total = 0;
            amount = 0;
            balance = 0;
        }
    }
}
