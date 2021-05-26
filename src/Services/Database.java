package Services;

import java.sql.*;

public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/paoproj";
    private static final String USER = "paouser";
    private static final String PASSWORD = "pass";

    private static Connection connection;

    public static Connection getConnection(){
        setup();
        return connection;
    }

    private static void setup(){
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//                String createTableSql = "CREATE TABLE IF NOT EXISTS items" +
//                        "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), description varchar(200)" +
//                        "startingPrice double, buyingPrice double, category_id int FOREIGN KEY REFERENCES() " +
//                        ")";
                //ResultSet res = executeQuerySql(connection, "select * from testt;");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
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

    //    public void displayPerson() {
    //        String selectSql = "SELECT * FROM persons";
    //
    //        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
    //        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();
    //
    //        try {
    //            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
    //            while (resultSet.next()) {
    //                System.out.println("Id:" + resultSet.getString(1));
    //                System.out.println("Name:" + resultSet.getString(2));
    //                System.out.println("Age:" + resultSet.getDouble(3));
    //            }
    //
    //        } catch (SQLException e) {
    //            e.printStackTrace();
    //        }
    //    }

    public static void executeSql(Connection connection, String sql) {
        try {
            Statement stmt = connection.createStatement();
            // execute() for updating (INSERT, UPDATE, DELETE) and SELECT instructions
            stmt.execute(sql);
            //ResultSet resultSet = stmt.getResultSet();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void executeUpdateSql(Connection connection, String sql) {
        try {
            Statement stmt = connection.createStatement();
            // executeUpdate() for updating the data (INSERT, UPDATE, DELETE) or the database structure
            int i = stmt.executeUpdate(sql); // no of altered lines
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuerySql(Connection connection, String sql) {
        try {
            Statement stmt = connection.createStatement();
            // executeQuery() for SELECT instructions
            return stmt.executeQuery(sql);
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
