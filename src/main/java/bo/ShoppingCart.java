package bo;

import db.ShoppingCartDB;

import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCart {

    private String username;

    private Collection items;

    static public ShoppingCartDB getShoppingCart(String username){
        return ShoppingCartDB.getUserList(username);
    }

    public static boolean addItem(String user, int itemId){
        return ShoppingCartDB.addItemDB(user,itemId);
    }

    public static boolean removeItemFromDB(String username, int itemId){
       return ShoppingCartDB.removeItem(username,itemId);
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
