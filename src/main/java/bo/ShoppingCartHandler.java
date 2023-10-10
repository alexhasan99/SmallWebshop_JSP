package bo;

import db.ShoppingCartDB;
import ui.ItemInfo;
import ui.ShoppingInfo;

import java.util.Iterator;

public class ShoppingCartHandler {

    /**
     * Retrieves the shopping cart of a user and converts it into a ShoppingInfo object.
     *
     * @param username The username of the user whose shopping cart to retrieve.
     * @return A ShoppingInfo object representing the user's shopping cart.
     */
    public static ShoppingInfo getShopCart(String username) {
        ShoppingInfo sh = new ShoppingInfo(username);
        for (Iterator it = ShoppingCart.getShoppingCart(username).getItems().iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            ItemInfo info = new ItemInfo(item.getName(), item.getDescr(), item.getImageData());
            info.setId(item.getId());
            sh.addItem(info);
        }
        return sh;
    }

    /**
     * Removes an item from a user's shopping cart.
     *
     * @param username The username of the user whose shopping cart to remove the item from.
     * @param itemId   The ID of the item to remove from the shopping cart.
     * @return `true` if the item was successfully removed from the shopping cart, `false` otherwise.
     */
    public static boolean removeItemFromCart(String username, int itemId) {
        return ShoppingCart.removeItemFromDB(username, itemId);
    }

    /**
     * Adds an item to a user's shopping cart.
     *
     * @param user   The username of the user whose shopping cart to add the item to.
     * @param itemId The ID of the item to add to the shopping cart.
     * @return `true` if the item was successfully added to the shopping cart, `false` otherwise.
     */
    public static boolean addItemToCart(String user, int itemId) {
        return ShoppingCart.addItem(user, itemId);
    }
}

