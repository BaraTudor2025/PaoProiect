package Services;

import java.sql.*;

public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/paoproj";
    private static final String USER = "paouser";
    private static final String PASSWORD = "pass";

    private static Connection connection = null;

    public static Connection getConnection(){
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
