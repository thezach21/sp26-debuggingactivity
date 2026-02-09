package main;

/**
 * This class represents a menu item for the restaurant. Each Item has a name, used to identify it;
 * a stock amount, used to track how many of it the restaurant has; and a price, used to determine
 * how much revenue the restaurant gains when that item is ordered.
 */
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
    public int getPrice() {return price;}

    /**
     * Decreases the current stock by the given amount.
     */
    public void decreaseStock(int amount) {
        this.stock -= amount;
    }
    /**
     * Increases the current stock by the given amount.
     */
    public void increaseStock(int amount) {
        this.stock += amount;
    }

    /**
     * Determines whether the item is in stock or not. An item is considered in stock
     * if its stock is more than 0.
     */
    public boolean isInStock() {
        return this.stock >= 0;
    }
}
