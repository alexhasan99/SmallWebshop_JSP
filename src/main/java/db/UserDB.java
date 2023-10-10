package db;
import bo.User;

import java.sql.*;

public class UserDB extends User {
    /**
     * Searches for a user with the specified username and password in the database.
     *
     * @param username The username of the user to search for.
     * @param password The password of the user to search for.
     * @return `true` if a user with the given username and password exists in the database, `false` otherwise.
     */
    public static boolean searchUser(String username, String password) {
        try (Connection con = DBManager.getConnection()) {
            String query = "SELECT id, name, password FROM users WHERE name = ? AND password = ?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Adds a new user with the specified username and password to the database.
     *
     * @param username The username of the user to add.
     * @param password The password of the user to add.
     * @return `true` if the user was successfully added to the database, `false` otherwise.
     */
    public static boolean addUser(String username, String password) {
        try (Connection con = DBManager.getConnection()) {
            String query = "INSERT INTO users (name, password) VALUES (?, ?)";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                // Handle the duplicate entry error here if needed.
                System.err.println("User already exists with the same username: " + username);
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    private UserDB(String username, String password, int id) {
        super(username, password, id);
    }
}
