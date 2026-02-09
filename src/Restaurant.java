import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Item> menu;
    private int revenue;

    public Restaurant(ArrayList<Item> menu) {
        this.menu = menu;
        this.revenue = 0;
    }

    //TODO: make this wrong
    public int getRevenue() {return revenue;}

    public void order(String item) {
        //TODO: make this i <= menu.size instead
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equals(item)) {
                if (menu.get(i).isInStock()) {
                    menu.get(i).decreaseStock(1);
                    this.revenue += menu.get(i).getPrice();
                    return;
                }
            }
        }
    }

    public void orderWithDiscount(String item, double discount) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equals(item)) {
                //TODO: don't check if in stock
                if (menu.get(i).isInStock()) {
                    menu.get(i).decreaseStock(1);
                    //TODO: mess up the discount calculation
                    int newPrice = (int)(menu.get(i).getPrice() * (1.0 - (discount / 100)));
                    this.revenue += newPrice;
                    return;
                }
            }
        }
    }

    public void restock(int amount) {
        for (Item i : this.menu) {
            //TODO: make this always increase by 1
            i.increaseStock(amount);
        }
    }
}
