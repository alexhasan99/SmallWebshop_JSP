package bo;

import db.ShoppingCartDB;

import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCart {

    private String username;

    private Collection items;

    /**
     * Retrieves a user's shopping cart from the database.
     *
     * @param username The username of the user whose shopping cart to retrieve.
     * @return A ShoppingCartDB object representing the user's shopping cart.
     */
    static public ShoppingCartDB getShoppingCart(String username) {
        return ShoppingCartDB.getUserList(username);
    }

    /**
     * Adds an item to a user's shopping cart in the database.
     *
     * @param user   The username of the user whose shopping cart to add the item to.
     * @param itemId The ID of the item to add to the shopping cart.
     * @return `true` if the item was successfully added to the shopping cart, `false` otherwise.
     */
    public static boolean addItem(String user, int itemId) {
        return ShoppingCartDB.addItemDB(user, itemId);
    }

    /**
     * Removes an item from a user's shopping cart in the database.
     *
     * @param username The username of the user whose shopping cart to remove the item from.
     * @param itemId   The ID of the item to remove from the shopping cart.
     * @return `true` if the item was successfully removed from the shopping cart, `false` otherwise.
     */
    public static boolean removeItemFromDB(String username, int itemId) {
        return ShoppingCartDB.removeItem(username, itemId);
    }


    protected ShoppingCart(String username, Collection items) {
        this.username = username;
        this.items = items;
    }

    public Collection getItems() {
        return items;
    }

    public void addItem(Item item){
       items.add(item);
    }

    public void deleteItem(Item item){
        items.remove(item);
    }


    public String getUserId() {
        return username;
    }
}
