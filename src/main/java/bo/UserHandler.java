package bo;

import db.ItemDB;
import db.UserDB;

public class UserHandler {
    public static boolean checkUser(String user, String password) {
        return UserDB.searchUser(user, password);
    }

    public static boolean addUser(String user, String password){
        return UserDB.addUser(user, password);
    }
}
