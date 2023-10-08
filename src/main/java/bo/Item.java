package bo;

import db.ItemDB;
import ui.ItemInfo;

import java.util.Collection;

public class Item {

    private String name;
    private int id;
    private String descr;

    private byte[] imageData;

    static public Collection searchItemsByCategory(String group){
        return ItemDB.searchItemsByCategory(group);
    }

    static public Collection getAllItems(){
        return ItemDB.getAllItems();
    }

    static public boolean addItemToDB(ItemInfo i, String category){
        return ItemDB.addItem(i,category);
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
