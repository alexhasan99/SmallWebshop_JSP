package db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class DBManager {
    private static DBManager instance = null;
    private BasicDataSource dataSource;

    private static DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    private DBManager() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/smallWebShop?user=root&password=test1212");
        System.out.println("Connection pool initialized!");
    }

    public static Connection getConnection() {
        try {
            return getInstance().dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
