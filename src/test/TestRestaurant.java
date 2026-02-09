package test;

import main.Item;
import main.Restaurant;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestRestaurant {

    @Test
    public void testOrder() {
        ArrayList<Item> menu = new ArrayList<>();
        menu.add(new Item("Pizza",5,15));
        menu.add(new Item("Steak",2,30));
        menu.add(new Item("French Fries",12,6));
        Restaurant restaurant = new Restaurant(menu);

        // revenue should start at 0
        assertEquals(0,restaurant.getRevenue());

        // ordering one item
        restaurant.order("Pizza");
        assertEquals(15,restaurant.getRevenue());

        // ordering another item, revenue should be the sum of the items' prices
        restaurant.order("French Fries");
        assertEquals(21,restaurant.getRevenue());

        // ordering an item until it is out of stock
        restaurant.order("Steak");
        restaurant.order("Steak");
        assertEquals(81,restaurant.getRevenue());
        // ordering the out-of-stock item should do nothing, revenue should be unchanged
        restaurant.order("Steak");
        assertEquals(81,restaurant.getRevenue());

        // ordering an item not on the menu should do nothing, revenue should be unchanged
        restaurant.order("Spaghetti");
        assertEquals(81,restaurant.getRevenue());
    }

    @Test
    public void testDiscount() {
        ArrayList<Item> menu = new ArrayList<>();
        menu.add(new Item("French Fries",12,6));
        menu.add(new Item("Pizza",5,15));
        menu.add(new Item("Steak",2,30));
        Restaurant restaurant = new Restaurant(menu);

        // ordering with 0% discount should work normally
        restaurant.orderWithDiscount("Pizza",0);
        assertEquals(15,restaurant.getRevenue());

        // ordering with a 50% discount should generate half the revenue, rounded down
        restaurant.orderWithDiscount("Pizza",50);
        assertEquals(22, restaurant.getRevenue());
        restaurant.orderWithDiscount("Steak",50);
        assertEquals(37,restaurant.getRevenue());
        restaurant.orderWithDiscount("French Fries",50);
        assertEquals(40,restaurant.getRevenue());

        // other discount amounts
        restaurant.orderWithDiscount("Pizza",66);
        assertEquals(45,restaurant.getRevenue());
        restaurant.orderWithDiscount("Pizza",33);
        assertEquals(55,restaurant.getRevenue());
        restaurant.orderWithDiscount("Steak",1);
        assertEquals(84,restaurant.getRevenue());
        restaurant.orderWithDiscount("French Fries",100);
        assertEquals(84,restaurant.getRevenue());

        // ordering out-of-stock items of items not on the menu should do nothing
        restaurant.orderWithDiscount("Steak",50);
        assertEquals(84,restaurant.getRevenue());
        restaurant.orderWithDiscount("Spaghetti",30);
        assertEquals(84,restaurant.getRevenue());
    }

    @Test
    public void testRestock() {
        ArrayList<Item> menu = new ArrayList<>();
        menu.add(new Item("Chicken Nuggets",2,8));
        menu.add(new Item("Burger",3,10));
        Restaurant restaurant = new Restaurant(menu);

        // get one item out of stock
        restaurant.order("Chicken Nuggets");
        restaurant.orderWithDiscount("Burger",50);
        restaurant.order("Chicken Nuggets");

        // check that item is out of stock
        assertEquals(21,restaurant.getRevenue());
        restaurant.order("Chicken Nuggets");
        assertEquals(21,restaurant.getRevenue());

        // restock 1 item and check stock again
        restaurant.restock(1);
        restaurant.order("Chicken Nuggets");
        assertEquals(29,restaurant.getRevenue());
        restaurant.order("Chicken Nuggets");
        assertEquals(29,restaurant.getRevenue());

        // check that second item also got restocked
        restaurant.order("Burger");
        restaurant.order("Burger");
        restaurant.order("Burger");
        assertEquals(59,restaurant.getRevenue());
        restaurant.order("Burger");
        assertEquals(59,restaurant.getRevenue());

        // restock by more than 1
        restaurant.restock(3);
        restaurant.order("Burger");
        restaurant.order("Burger");
        restaurant.order("Burger");
        assertEquals(89,restaurant.getRevenue());
        restaurant.order("Burger");
        assertEquals(89,restaurant.getRevenue());
    }
}
