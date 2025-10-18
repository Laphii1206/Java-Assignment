import java.util.Scanner;

public class PrjF1G8Main {

    static final int MAX_BOXES = 100;
    static PrjF1G8Storage[] boxes = new PrjF1G8Storage[MAX_BOXES];
    static final double TOTAL_CABINET_CAPACITY = 1000000;
    static double TotalUsedCapacity = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("============================");
            System.out.println("===CABINET STORAGE SYSTEM===");
            System.out.println("============================");
            System.out.println("1. Add Storage Box");
            System.out.println("2. Add Item into Box");
            System.out.println("3. View Items in Box");
            System.out.println("4. Exit");
            System.out.println("============================");
            System.out.print("Enter your choice: (1-4): ");

            char choice = sc.next().charAt(0);
            sc.nextLine();

            switch (choice) {
                case '1' ->
                    addStorageBox(sc);
                case '2' ->
                    addItemToBox(sc);
                case '3' ->
                    viewBoxes();
                case '4' -> {
                    System.out.println("Thank you for using our system!");
                    sc.close();
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addStorageBox(Scanner sc) {
        if (PrjF1G8Storage.count >= MAX_BOXES) {
            System.out.println("Cabinet is full!");
            return;
        }

        System.out.print("Enter box label: ");
        String label = sc.nextLine();

        boolean duplicateLabel = false;
        for (int i = 0; i < PrjF1G8Storage.count; i++) {
            if (boxes[i].getLabel().equals(label)) {
                duplicateLabel = true;
                break;
            }
        }

        if (duplicateLabel) {
            System.out.println("Label already exists! Please use another label.");
            return;
        }

        System.out.print("Enter box capacity (cm3): ");
        double capacity = sc.nextDouble();
        sc.nextLine();

        if (capacity <= 0) {
            System.out.println("Capacity must be a positive value.");
            return;
        }

        if (capacity > TOTAL_CABINET_CAPACITY) {
            System.out.println("Box capacity exceeds the total cabinet size (" + TOTAL_CABINET_CAPACITY + " cm3)!");
            return;
        }

        if (TotalUsedCapacity + capacity > TOTAL_CABINET_CAPACITY) {
            System.out.println("Not enough space in the cabinet!");
            return;
        }

        boxes[PrjF1G8Storage.count] = new PrjF1G8Storage(label, capacity);
        TotalUsedCapacity += capacity;
        System.out.println("Storage box \"" + label + "\" added successfully.");
        System.out.println("CABINET SPACE LEFT: " + (TOTAL_CABINET_CAPACITY - TotalUsedCapacity) + "cm3");

    }

    public static void addItemToBox(Scanner sc) {
        int choice;
        if (PrjF1G8Storage.count == 0) {
            System.out.println("No boxes available. Please add a storage box first.");
            return;
        }

        System.out.print("Choose which label do you want to store the item: \n");

        for (int i = 0; i < PrjF1G8Storage.count; i++) {
            System.out.println(1 + i + ". " + boxes[i].getLabel() + " | Remaining Space: "
                    + (boxes[i].getStorageSize() - boxes[i].getCurrentUsedSpace()) + " cm3");
        }
        System.out.print("Selection: ");

        choice = Integer.parseInt(sc.nextLine());

        if (choice < 0 || choice > PrjF1G8Storage.count) {
            System.out.println("Invalid Selection for Label");
            return;
        }

        System.out.print("\nEnter item name: ");
        String itemName = sc.nextLine();

        System.out.print("\nEnter item capacity (cm3): ");
        double itemSize = sc.nextDouble();
        sc.nextLine();

        if (itemSize <= 0) {
            System.out.println("Invalid item size");
            return;
        }

        if (itemSize > boxes[choice - 1].getStorageSize() - boxes[choice - 1].getCurrentUsedSpace()) {
            System.out.println("item size exceeds the Storage Size Limit");
            return;
        }

        boxes[choice - 1].addItem(itemName, itemSize);

    }

    public static void viewBoxes() {
        if (PrjF1G8Storage.count == 0) {
            System.out.println("No boxes available.");
            return;
        }
        System.out.println("Label\t\t| Capacity\t\t| Used Space\t\t| Remaining Space\t| Items (Name, Size)");
        System.out.println(
                "----------------|-----------------------|-----------------------|-----------------------|--------------------------------");

        for (int i = 0; i < PrjF1G8Storage.count; i++) {
            System.out.println(boxes[i].toString());
        }
    }
}