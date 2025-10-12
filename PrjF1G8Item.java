class Item {
private String name;
    private double size;
    
    public Item(String name, double size) {
        this.name = name;
        this.size = size;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSize() {
        return size;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %15.2f", name, size);
    }
}

