package main;

public class Item {

    private String name;
    private int price;
    private int stock;

    public Item(String name, int stock, int price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public void decreaseStock(int amount) {
        this.stock -= amount;
    }
    public void increaseStock(int amount) {
        this.stock += amount;
    }

    public boolean isInStock() {
        return this.stock >= 0;
    }
}
