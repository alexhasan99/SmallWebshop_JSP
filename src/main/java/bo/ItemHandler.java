package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> getItemsWithGroup(String s) {
        Collection c = Item.searchItemsByCategory(s);
        return getItems(c);
    }

    public static Collection<ItemInfo> getAllItems() {
        Collection c = Item.getAllItems();
        return getItems(c);
    }

    private static Collection<ItemInfo> getItems(Collection c) {
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            ItemInfo info= new ItemInfo(item.getName(),item.getDescr(), item.getImageData());
            info.setId(item.getId());
            items.add(info);
        }
        return items;
    }

    public static ItemInfo getItemById(int id){
        Item item= (Item) Item.getById(id);
        ItemInfo info= new ItemInfo(item.getName(),item.getDescr(), item.getImageData());
        info.setId(item.getId());
        return info;
    }

    public static boolean addItem(ItemInfo item, String category){
        Item i= new Item(item.getId(),item.getName(),
                item.getDescription(), item.getImageData());

        return Item.addItemToDB(i, category);
    }
}
