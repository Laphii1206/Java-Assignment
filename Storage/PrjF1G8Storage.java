public class PrjF1G8Storage {

    private String Storagelabel;
    private double StorageSize;
    public static int count = 0;
    private int itemBoxCount = 0;
    private double CurrentUsedSpace = 0.0;
    private PrjF1G8Item[] item = new PrjF1G8Item[100];

    {
        count++;
    }

    public PrjF1G8Storage() {
        Storagelabel = "N/A";
        StorageSize = 0;
    }

    public PrjF1G8Storage(String label, Double size) {
        Storagelabel = label;
        StorageSize = size;
    }

    public double getCurrentUsedSpace() {
        return CurrentUsedSpace;
    }

    public String getLabel() {
        return Storagelabel;
    }

    public double getStorageSize() {
        return StorageSize;
    }

    public void addItem(String n, double s) {

        if (itemBoxCount >= 100) {
            System.out.println("Storagebox is full! (Max 100 items)");
            return;
        }

        item[itemBoxCount] = new PrjF1G8Item(n, s);
        CurrentUsedSpace += s;
        itemBoxCount++;

        System.out.println("Item '" + n + "' added to " + Storagelabel);
    }

    public String toString() {
        String itemsList;
        if (itemBoxCount == 0) {
            itemsList = "(Empty)";
        } else {
            String list = "";
            for (int i = 0; i < itemBoxCount; i++) {
                if (i > 0) {
                    list = list + ", ";
                }
                list = list + item[i].toString();
            }
            itemsList = list;
        }
        String output = Storagelabel + "\t\t| ";

        output += " " + StorageSize + " cm3\t\t" + "| ";

        output += " " + CurrentUsedSpace + " cm3\t\t" + "| ";

        output += " " + (StorageSize - CurrentUsedSpace) + " cm3\t\t" + "| ";

        output += itemsList;
        return output;
    }
}