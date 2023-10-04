package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManger {
    private static DBManger instance= null;
    private Connection con= null;

    private static DBManger getInstance(){
        if (instance== null)
            instance = new DBManger();
        return instance;
    }
    private DBManger() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con= DriverManager.getConnection("jdbc:mysql://localhost/smallWebShop?user=root&password=test1212");
            System.out.println("Connection successful!");
        }catch (Exception e) {e.printStackTrace();}
    }

    public static Connection getConnection(){return getInstance().con;};
}
