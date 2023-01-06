package ua.edu.ucu.decorator;

import lombok.SneakyThrows;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbconnection;

    private Connection connection;

    @SneakyThrows
    private DBConnection() {
        connection = DriverManager.getConnection("jdbc:sqlite:db_lab12.sqlite3");
    }

    @SneakyThrows
    public void executeQuery(String query) {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    @SneakyThrows
    public String searchQuery(String query){
        PreparedStatement p;
        ResultSet rs;
        p = connection.prepareStatement(query);
        rs = p.executeQuery();
        if(rs!=null){
            return rs.getString("documentText");
        }
        return null;
    }

    public static DBConnection getInstance() {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }
}
