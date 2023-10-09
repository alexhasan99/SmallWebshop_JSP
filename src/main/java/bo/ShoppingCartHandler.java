package bo;

import db.ShoppingCartDB;
import ui.ItemInfo;
import ui.ShoppingInfo;

import java.util.Iterator;

public class ShoppingCartHandler {

    public static ShoppingInfo getShopCart(String username){
        ShoppingInfo sh= new ShoppingInfo(username);
        for (Iterator it = ShoppingCart.getShoppingCart(username).getItems().iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            ItemInfo info= new ItemInfo(item.getName(),item.getDescr(), item.getImageData());
            info.setId(item.getId());
            sh.addItem(info);
        }
        return sh;
    }
    public static boolean removeItemFromCart(String username, int itemId){
        return ShoppingCart.removeItemFromDB(username,itemId);
    }

    public static boolean addItemToCart(String user, int itemId){
        return ShoppingCart.addItem(user,itemId);
    }

}
