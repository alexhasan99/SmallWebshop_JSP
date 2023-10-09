package db;

import bo.Item;
import ui.ItemInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends bo.Item {
    public static Collection searchItemsByCategory(String categoryName) {
        return searchItemsByCategoryInternal(categoryName, false);
    }

    public static Collection getAllItems() {
        return searchItemsByCategoryInternal(null, true);
    }

    private static Collection searchItemsByCategoryInternal(String categoryName, boolean getAllItems) {
        Vector items = new Vector();

        try (Connection con = DBManager.getConnection()) {
            String query = "SELECT i.id, i.name, i.description, ii.image_data " +
                    "FROM items i " +
                    "LEFT JOIN item_images ii ON i.id = ii.item_id ";
            if (!getAllItems) {
                query += "WHERE i.category_id = (SELECT id FROM categories WHERE name = ?)";
            }

            try (PreparedStatement statement = con.prepareStatement(query)) {
                if (!getAllItems) {
                    statement.setString(1, categoryName);
                }
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String description = rs.getString("description");

                        // Get the BLOB data
                        Blob imageDataBlob = rs.getBlob("image_data");
                        byte[] imageData = null;
                        if (imageDataBlob != null) {
                            imageData = imageDataBlob.getBytes(1, (int) imageDataBlob.length());
                        }
                        ItemDB item = new ItemDB(id, name, description, imageData);
                        items.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static ItemDB getItemById(int id){
        ItemDB item= null;
        try (Connection connection = DBManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT i.name, i.description, i.category_id, ii.image_data " +
                             "FROM items AS i " +
                             "LEFT JOIN item_images AS ii ON i.id = ii.item_id " +
                             "WHERE i.id = ?")) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int categoryId = resultSet.getInt("category_id");
                    byte[] imageData = resultSet.getBytes("image_data");

                    // Skapa ett Item-objekt med hämtade data inklusive bilddata
                    item = new ItemDB(id, name, description, imageData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public static boolean addItem(Item item, String categoryName) {
        try (Connection con = DBManager.getConnection()) {
            // Hämta category_id för den angivna kategorin
            String categoryIdQuery = "SELECT id FROM categories WHERE name = ?";
            int categoryId = -1; // Standardvärde om kategorin inte hittas
            try (PreparedStatement categoryIdStatement = con.prepareStatement(categoryIdQuery)) {
                categoryIdStatement.setString(1, categoryName);
                try (ResultSet categoryIdResultSet = categoryIdStatement.executeQuery()) {
                    if (categoryIdResultSet.next()) {
                        categoryId = categoryIdResultSet.getInt("id");
                        System.out.println(categoryId);
                    }
                }
            }
            if (categoryId == -1) {
                // Kategorin hittades inte, returnera false
                return false;
            }

            String insertItemQuery = "INSERT INTO items (name, description, category_id) VALUES (?, ?, ?)";
            try (PreparedStatement itemStatement = con.prepareStatement(insertItemQuery, Statement.RETURN_GENERATED_KEYS)) {
                itemStatement.setString(1, item.getName());
                itemStatement.setString(2, item.getDescr());
                itemStatement.setInt(3, categoryId);
                System.out.println(item.getName());
                System.out.println(item.getDescr());
                int rowsAffected = itemStatement.executeUpdate();
                System.out.println(rowsAffected);
                if (rowsAffected == 0) {
                    // Inget objekt lades till
                    return false;
                }

                // Hämta det genererade nyckelvärdet (id) för det nya objektet
                try (ResultSet generatedKeys = itemStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int itemId = generatedKeys.getInt(1);

                        // Lägg till bilddata i item_images-tabellen
                        String insertImageQuery = "INSERT INTO item_images (item_id, image_data) VALUES (?, ?)";
                        try (PreparedStatement imageStatement = con.prepareStatement(insertImageQuery)) {
                            imageStatement.setInt(1, itemId);
                            imageStatement.setBytes(2, item.getImageData());

                            imageStatement.executeUpdate();
                        }
                        return true;
                    } else {
                        // Inget nyckelvärde genererades
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private ItemDB(int id, String name, String descr, byte[] imageData) {
        super(id, name, descr, imageData);
    }

}


// Search by category

// Search by name

// View All Items