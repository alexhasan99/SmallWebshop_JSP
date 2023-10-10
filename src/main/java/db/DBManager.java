package db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
    /**
     * A singleton class for managing database connections using a connection pool.
     */
    public class DBManager {

        private static DBManager instance = null;
        private BasicDataSource dataSource;

        /**
         * Private constructor for creating a DBManager instance and initializing the connection pool.
         */
        private DBManager() {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost/smallWebShop?user=root&password=test1212");
            System.out.println("Connection pool initialized!");
        }

        /**
         * Retrieves the singleton instance of the DBManager.
         *
         * @return The singleton instance of the DBManager.
         */
        private static DBManager getInstance() {
            if (instance == null)
                instance = new DBManager();
            return instance;
        }

        /**
         * Gets a database connection from the connection pool.
         *
         * @return A database connection if successful, or null if an error occurs.
         */
        public static Connection getConnection() {
            try {
                return getInstance().dataSource.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

