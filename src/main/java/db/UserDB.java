package db;

import bo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class UserDB extends User {
    public static boolean searchUser(String username, String password) {

        try {
            Connection con = DBManger.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, password FROM users WHERE name = '" + username + "' AND password = '" + password + "'");
            while (rs.next()) {
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String pass = rs.getString("password");
                UserDB t= new UserDB(username, password, i);
                if (t.getUsername().equals(username) && t.getPassword().equals(password))
                    return true;
            }
        }catch (SQLException e){e.printStackTrace();}

        return false;
    }

    private UserDB(String username, String password, int id) {
        super(username, password, id);
    }
}
