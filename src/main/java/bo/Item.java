package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {

    private String name;
    private int id;
    private String descr;

    static public Collection searchItems(String group){
        return ItemDB.searchItems(group);
    }

    protected Item (int id, String name, String descr){
        this.id= id;
        this.name= name;
        this.descr= descr;
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
}
