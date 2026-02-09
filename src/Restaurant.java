import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Item> menu;
    private int revenue;

    public Restaurant(ArrayList<Item> menu) {
        this.menu = menu;
        this.revenue = 0;
    }

    public int getRevenue() {return 0;}

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

    public void restock(int amount) {
        for (Item i : this.menu) {
            i.increaseStock(1);
        }
    }
}
