package db;

import bo.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCartDB extends ShoppingCart {

    /**
     * Retrieves a user's shopping cart from the database and returns it as a ShoppingCartDB object.
     *
     * @param username The username of the user whose shopping cart to retrieve.
     * @return A ShoppingCartDB object representing the user's shopping cart.
     */
    public static ShoppingCartDB getUserList(String username) {
        ShoppingCartDB itemsInCart = null;
        try (Connection connection = DBManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, item_id " +
                             "FROM shopping_cart_items " +
                             "WHERE username = ?")) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                itemsInCart = new ShoppingCartDB(username, new ArrayList<>());
                while (resultSet.next()) {
                    int itemId = resultSet.getInt("item_id");
                    itemsInCart.addItem(ItemDB.getItemById(itemId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsInCart;
    }

    /**
     * Adds an item to a user's shopping cart in the database.
     *
     * @param user   The username of the user whose shopping cart to add the item to.
     * @param itemId The ID of the item to add to the shopping cart.
     * @return `true` if the item was successfully added to the shopping cart, `false` otherwise.
     */
    public static boolean addItemDB(String user, int itemId) {
        try (Connection connection = DBManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO shopping_cart_items (username, item_id) VALUES (?, ?)")) {
            preparedStatement.setString(1, user);
            preparedStatement.setInt(2, itemId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Removes an item from a user's shopping cart in the database.
     *
     * @param username The username of the user whose shopping cart to remove the item from.
     * @param itemId   The ID of the item to remove from the shopping cart.
     * @return `true` if the item was successfully removed from the shopping cart, `false` otherwise.
     */
    public static boolean removeItem(String username, int itemId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBManager.getConnection();
            String deleteQuery = "DELETE FROM shopping_cart_items WHERE username = ? AND item_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, itemId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Return true if at least one item was removed
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // If something goes wrong, return false
        }
    }



    private ShoppingCartDB(String username, Collection items) {
        super(username, items);
    }
}
