class Item{
    String name;
    double size;

    Item(String n,int s){
        this.name = n;
        this.size = s;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\t Size:" + size;
    }
}