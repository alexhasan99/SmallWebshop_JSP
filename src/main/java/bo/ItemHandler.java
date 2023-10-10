package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    /**
     * Retrieves items with a specified category and converts them into a collection of ItemInfo objects.
     *
     * @param s The category to search for.
     * @return A collection of ItemInfo objects representing items in the specified category.
     */
    public static Collection<ItemInfo> getItemsWithGroup(String s) {
        Collection c = Item.searchItemsByCategory(s);
        return getItems(c);
    }

    /**
     * Retrieves all items and converts them into a collection of ItemInfo objects.
     *
     * @return A collection of ItemInfo objects representing all items in the database.
     */
    public static Collection<ItemInfo> getAllItems() {
        Collection c = Item.getAllItems();
        return getItems(c);
    }

    /**
     * Converts a collection of items into a collection of ItemInfo objects.
     *
     * @param c The collection of items to convert.
     * @return A collection of ItemInfo objects representing the input items.
     */
    private static Collection<ItemInfo> getItems(Collection c) {
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            ItemInfo info = new ItemInfo(item.getName(), item.getDescr(), item.getImageData());
            info.setId(item.getId());
            items.add(info);
        }
        return items;
    }

    /**
     * Retrieves an item by its unique identifier and converts it into an ItemInfo object.
     *
     * @param id The unique identifier of the item to retrieve.
     * @return An ItemInfo object representing the item with the specified ID.
     */
    public static ItemInfo getItemById(int id) {
        Item item = (Item) Item.getById(id);
        ItemInfo info = new ItemInfo(item.getName(), item.getDescr(), item.getImageData());
        info.setId(item.getId());
        return info;
    }

    /**
     * Adds an ItemInfo object to the database with the specified category.
     *
     * @param item     The ItemInfo object to add to the database.
     * @param category The category to which the item belongs.
     * @return `true` if the item was successfully added to the database, `false` otherwise.
     */
    public static boolean addItem(ItemInfo item, String category) {
        Item i = new Item(item.getId(), item.getName(), item.getDescription(), item.getImageData());
        return Item.addItemToDB(i, category);
    }

}
