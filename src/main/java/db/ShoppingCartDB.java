package db;

import bo.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCartDB extends ShoppingCart {

    public static ShoppingCartDB getUserList(String username) {

        ShoppingCartDB itemsInCart = null;
        try (Connection connection = DBManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, item_id " +
                             "FROM shopping_cart_items " +
                             "WHERE username = ?")) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                itemsInCart = new ShoppingCartDB (username, new ArrayList<>());
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

            return rowsAffected > 0; // Returnera true om minst ett objekt togs bort
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Om något går fel, returnera false
        }
    }


    private ShoppingCartDB(String username, Collection items) {
        super(username, items);
    }
}
