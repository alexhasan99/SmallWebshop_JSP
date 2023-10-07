package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> getItemsWithGroup(String s) {
        Collection c = Item.searchItemsByCategory(s);
        return getItemInfos(c);
    }

    private static Collection<ItemInfo> getItemInfos(Collection c) {
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(),item.getDescr(), item.getImageData()));
        }
        return items;
    }

    public static Collection<ItemInfo> getAllItems() {
        Collection c = Item.getAllItems();
        return getItemInfos(c);
    }

    public static boolean addItem(ItemInfo item, String category){
        System.out.println();
        return Item.addItemToDB(item, category);
    }
}
