package bo;

import db.ItemDB;
import db.UserDB;

public class UserHandler {
    /**
     * Checks if a user with the specified username and password exists in the user database.
     *
     * @param user     The username of the user to check.
     * @param password The password of the user to check.
     * @return `true` if the user with the given username and password exists in the database, `false` otherwise.
     */
    public static boolean checkUser(String user, String password) {
        return UserDB.searchUser(user, password);
    }

    /**
     * Adds a new user with the specified username and password to the user database.
     *
     * @param user     The username of the user to add.
     * @param password The password of the user to add.
     * @return `true` if the user was successfully added to the database, `false` otherwise.
     */
    public static boolean addUser(String user, String password) {
        return UserDB.addUser(user, password);
    }
}
