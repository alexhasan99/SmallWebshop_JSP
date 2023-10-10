package bo;

import db.ItemDB;
import ui.ItemInfo;

import java.util.Collection;

public class Item {

    private String name;
    private int id;
    private String descr;

    private byte[] imageData;

    /**
     * Searches for items by the specified category.
     *
     * @param group The category to search for.
     * @return A collection of items that belong to the specified category.
     */
    static public Collection searchItemsByCategory(String group) {
        return ItemDB.searchItemsByCategory(group);
    }

    /**
     * Retrieves all items from the database.
     *
     * @return A collection containing all items in the database.
     */
    static public Collection getAllItems() {
        return ItemDB.getAllItems();
    }

    /**
     * Adds an item to the database with the specified category.
     *
     * @param i        The item to be added to the database.
     * @param category The category to which the item belongs.
     * @return `true` if the item was successfully added to the database, `false` otherwise.
     */
    static public boolean addItemToDB(Item i, String category) {
        return ItemDB.addItem(i, category);
    }


    static public Object getById(int id){
        return ItemDB.getItemById(id);
    }

    protected Item (int id, String name, String descr, byte[] imageData){
        this.id= id;
        this.name= name;
        this.descr= descr;
        this.imageData=imageData;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescr() {
        return descr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", descr='" + descr + '\'' +
                '}';
    }
}
