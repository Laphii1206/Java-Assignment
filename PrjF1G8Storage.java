class Storage {
private String label;
    private double capacity;
    private double usedSpace;
    private Item[] items;
    private int itemCount;
    
    public Storage(String label, double capacity) {
        this.label = label;
        this.capacity = capacity;
        this.usedSpace = 0;
        this.items = new Item[100];
        this.itemCount = 0;
    }
    
    public String getLabel() {
        return label;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getUsedSpace() {
        return usedSpace;
    }
    
    public double getRemainingSpace() {
        return capacity - usedSpace;
    }
    
    public boolean addItem(Item item) {
        if (item.getSize() > getRemainingSpace()) {
            return false;
        }
        items[itemCount] = item;
        itemCount++;
        usedSpace += item.getSize();
        return true;
    }
    
    public void viewItems() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println(String.format("Storage Box: %-20s", label));
        System.out.println(String.format("Capacity    : %15.2f cm³", capacity));
        System.out.println(String.format("Used Space  : %15.2f cm³", usedSpace));
        System.out.println(String.format("Remaining   : %15.2f cm³", getRemainingSpace()));
        System.out.println("-".repeat(80));
        
        if (itemCount == 0) {
            System.out.println("No items in this storage box.");
        } else {
            System.out.println(String.format("%-20s %15s", "Item Name", "Size (cm³)"));
            System.out.println("-".repeat(80));
            for (int i = 0; i < itemCount; i++) {
                System.out.println(items[i].toString());
            }
        }
        System.out.println("=".repeat(80));
    }
    
    @Override
    public String toString() {
        return String.format("%-20s | Capacity: %12.2f | Used: %12.2f | Remaining: %12.2f", 
                           label, capacity, usedSpace, getRemainingSpace());
    }
}
