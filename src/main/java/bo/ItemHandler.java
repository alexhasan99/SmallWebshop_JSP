package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> getItemsWithGroup(String s) {
        Collection c = Item.searchItemsByCategory(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(),item.getDescr(), item.getImageData()));
        }
        return items;
    }

    public static Collection<ItemInfo> getAllItems() {
        Collection c = Item.getAllItems();
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(),item.getDescr(), item.getImageData()));
        }
        return items;
    }
}
