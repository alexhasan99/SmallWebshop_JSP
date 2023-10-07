package db;
import bo.User;
import db.DBManger;
import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class UserDB extends User {
    public static boolean searchUser(String username, String password) {
        try (Connection con = DBManger.getConnection()) {
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

    public static boolean addUser(String username, String password) {
        try (Connection con = DBManger.getConnection()) {
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
