package com.team2.utill;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    // Database connection details
    private static final String url = "jdbc:mysql://localhost:3306/librarySystem";
    private static final String username = "root";
    private static final String password = "";

    // Load the MySQL JDBC driver (static block for initialization)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: JDBC Driver not found! " + e.getMessage());
        }
    }

    // Get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Prepare a statement
    public static PreparedStatement setStatment(String sql) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = getConnection(); // Get the connection here
            stmt = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new SQLException("Connection failed: " + e.getMessage(), e);
        } finally {
            closeResources(connection, stmt);
        }
        return stmt;
    }

    // Close database resources safely
    public static void closeResources(Connection con, PreparedStatement pst) {
        try {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error in closing resources: " + ex.getMessage());
        }
    }
}