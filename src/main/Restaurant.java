package main;

import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Item> menu;
    private int revenue;

    public Restaurant(ArrayList<Item> menu) {
        this.menu = menu;
        this.revenue = 0;
    }

    /**
     * Returns the total revenue the restaurant has earned, as tracked by the revenue instance variable.
     */
    public int getRevenue() {return 0;}

    /**
     * Orders the menu item named in the parameter. To do this, the menu is scanned for an
     * item with the same name as the string parameter. If that item is found, it is checked to see
     * if it is in stock. If it is, the item's stock is decreased by 1 and the restaurant earns revenue
     * equal to the item's price. If the item is out of stock, or if the menu does not contain an item
     * with that name, this method does nothing.
     */
    public void order(String item) {
        for (int i = 0; i <= menu.size(); i++) {
            if (menu.get(i).getName().equals(item)) {
                if (menu.get(i).isInStock()) {
                    menu.get(i).decreaseStock(1);
                    this.revenue += menu.get(i).getPrice();
                    return;
                }
            }
        }
    }

    /**
     * Orders the menu item named in the parameter, same as above, but applying a
     * discount to the item's price. When the item's price is being added to the restaurant's
     * revenue, it is decreased by the amount in the double parameter as a percent.
     * For example, calling this method to order an item with a price of 10 with a discount
     * of 30 would be ordering the item at 30% off, so the restaurant would gain 7 revenue.
     * This method should not modify the actual price of the item.
     */
    public void orderWithDiscount(String item, double discount) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equals(item)) {
                menu.get(i).decreaseStock(1);
                int newPrice = (int)(menu.get(i).getPrice() * (1.0 + (discount / 100)));
                this.revenue += newPrice;
                return;
            }
        }
    }

    /**
     * Increases the stock of every item in the restaurant by the amount specified in the parameter.
     */
    public void restock(int amount) {
        for (Item i : this.menu) {
            i.increaseStock(1);
        }
    }
}
