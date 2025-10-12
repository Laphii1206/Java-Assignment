import java.util.Scanner;

public class PrjF1G8Main {
    private static final double CABINET_CAPACITY = 1000000.0;
    private static Storage[] storageBoxes = new Storage[50];
    private static int storageCount = 0;
    private static double totalUsedSpace = 0;
    public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
        int choice;
        
        System.out.println("*".repeat(80));
        System.out.println("                        STORAGE SYSTEM MANAGER");
        System.out.println("*".repeat(80));
        System.out.println("Cabinet Capacity: " + CABINET_CAPACITY + " cm³\n");
        
        do {
            displayMenu();
            choice = getValidChoice(scanner);
            
            switch (choice) {
                case 1:
                    addStorageBox(scanner);
                    break;
                case 2:
                    addItemToStorage(scanner);
                    break;
                case 3:
                    viewAllStorageBoxes();
                    break;
                case 4:
                    System.out.println("\nThank you for using Storage System Manager. Goodbye!");
                    break;
            }
        } while (choice != 4);
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                                MENU");
        System.out.println("=".repeat(80));
        System.out.println("1. Add Storage Box");
        System.out.println("2. Put Item into Storage Box");
        System.out.println("3. View Items in Storage Boxes");
        System.out.println("4. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice (1-4): ");
    }
    
    private static int getValidChoice(Scanner scanner) {
        int choice = 0;
        boolean valid = false;
        
        while (!valid) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    valid = true;
                } else {
                    System.out.print("Invalid choice! Please enter 1-4: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number (1-4): ");
            }
        }
        return choice;
    }
    
    private static void addStorageBox(Scanner scanner) {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("                          ADD STORAGE BOX");
        System.out.println("-".repeat(80));
        
        System.out.print("Enter storage box label: ");
        String label = scanner.nextLine().trim();
        
        if (label.isEmpty()) {
            System.out.println("Error: Label cannot be empty!");
            return;
        }
        
        for (int i = 0; i < storageCount; i++) {
            if (storageBoxes[i].getLabel().equalsIgnoreCase(label)) {
                System.out.println("Error: A storage box with label '" + label + "' already exists!");
                return;
            }
        }
        
        double capacity = 0;
        boolean validCapacity = false;
        
        while (!validCapacity) {
            System.out.print("Enter storage box capacity (cm³): ");
            try {
                capacity = Double.parseDouble(scanner.nextLine());
                if (capacity <= 0) {
                    System.out.println("Error: Capacity must be greater than 0!");
                } else if (totalUsedSpace + capacity > CABINET_CAPACITY) {
                    System.out.printf("Error: Not enough space in cabinet! Available: %.2f cm³\n", 
                                    CABINET_CAPACITY - totalUsedSpace);
                    return;
                } else {
                    validCapacity = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            }
        }
        
        storageBoxes[storageCount] = new Storage(label, capacity);
        storageCount++;
        totalUsedSpace += capacity;
        
        System.out.println("\nSuccess: Storage box '" + label + "' added successfully!");
        System.out.printf("Cabinet space remaining: %.2f cm³\n", CABINET_CAPACITY - totalUsedSpace);
    }
    
    private static void addItemToStorage(Scanner scanner) {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("                      PUT ITEM INTO STORAGE BOX");
        System.out.println("-".repeat(80));
        
        if (storageCount == 0) {
            System.out.println("Error: No storage boxes available. Please add a storage box first.");
            return;
        }
        
        System.out.println("Available Storage Boxes:");
        for (int i = 0; i < storageCount; i++) {
            System.out.println((i + 1) + ". " + storageBoxes[i].toString());
        }
        
        System.out.print("\nEnter storage box label: ");
        String label = scanner.nextLine().trim();
        
        int storageIndex = -1;
        for (int i = 0; i < storageCount; i++) {
            if (storageBoxes[i].getLabel().equalsIgnoreCase(label)) {
                storageIndex = i;
                break;
            }
        }
        
        if (storageIndex == -1) {
            System.out.println("Error: Storage box '" + label + "' not found!");
            return;
        }
        
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine().trim();
        
        if (itemName.isEmpty()) {
            System.out.println("Error: Item name cannot be empty!");
            return;
        }
        
        double itemSize = 0;
        boolean validSize = false;
        
        while (!validSize) {
            System.out.print("Enter item size (cm³): ");
            try {
                itemSize = Double.parseDouble(scanner.nextLine());
                if (itemSize <= 0) {
                    System.out.println("Error: Item size must be greater than 0!");
                } else {
                    validSize = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            }
        }
        
        Item newItem = new Item(itemName, itemSize);
        
        if (storageBoxes[storageIndex].addItem(newItem)) {
            System.out.println("\nSuccess: Item '" + itemName + "' added to storage box '" + label + "'!");
            System.out.printf("Remaining space in storage box: %.2f cm³\n", 
                            storageBoxes[storageIndex].getRemainingSpace());
        } else {
            System.out.println("\nError: Not enough space in storage box '" + label + "'!");
            System.out.printf("Item size: %.2f cm³, Available space: %.2f cm³\n", 
                            itemSize, storageBoxes[storageIndex].getRemainingSpace());
        }
    }
    
    private static void viewAllStorageBoxes() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("                      VIEW ALL STORAGE BOXES");
        System.out.println("-".repeat(80));
        
        if (storageCount == 0) {
            System.out.println("No storage boxes available.");
            return;
        }
        
        for (int i = 0; i < storageCount; i++) {
            storageBoxes[i].viewItems();
        }
        
        System.out.println("\nCabinet Summary:");
        System.out.printf("Total Storage Boxes: %d\n", storageCount);
        System.out.printf("Cabinet Capacity   : %.2f cm³\n", CABINET_CAPACITY);
        System.out.printf("Space Used         : %.2f cm³\n", totalUsedSpace);
        System.out.printf("Space Remaining    : %.2f cm³\n", CABINET_CAPACITY - totalUsedSpace);
    }
}