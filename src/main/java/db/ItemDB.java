package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends bo.Item {
    public static Collection searchItemsByCategory(String categoryName) {
        ArrayList items = new ArrayList();

        try (Connection con = DBManger.getConnection()) {
            String query = "SELECT i.id, i.name, i.description, ii.image_data " +
                    "FROM items i " +
                    "LEFT JOIN item_images ii ON i.id = ii.item_id " +
                    "WHERE i.category_id = (SELECT id FROM categories WHERE name = ?)";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, categoryName);
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

    public static Collection getAllItems (){
        Vector items = new Vector();

        try (Connection con = DBManger.getConnection()) {
            String query = "SELECT i.id, i.name, i.description, ii.image_data " +
                    "FROM items i " +
                    "LEFT JOIN item_images ii ON i.id = ii.item_id";
            try (PreparedStatement statement = con.prepareStatement(query)) {
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

    private ItemDB(int id, String name, String descr, byte[] imageData) {
        super(id, name, descr, imageData);
    }

}




// Search by category

// Search by name

// View All Items