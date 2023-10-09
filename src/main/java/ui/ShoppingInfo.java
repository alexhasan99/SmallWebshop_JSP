package ui;


import java.util.ArrayList;

public class ShoppingInfo {
    private String username;

    private ArrayList<ItemInfo> items;

    public ShoppingInfo(String username) {
        this.username = username;
        this.items = new ArrayList<>();
    }

    public ArrayList<ItemInfo> getItems() {
        return (ArrayList<ItemInfo>) items.clone();
    }

    public void addItem(ItemInfo item){
        items.add(item);
    }

    public void deleteItem(ItemInfo item){
        items.remove(item);
    }


    public String getUserId() {
        return username;
    }
}
