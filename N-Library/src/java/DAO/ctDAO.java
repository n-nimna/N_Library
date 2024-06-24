/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Model;
import model.Model1;

/**
 *
 * @author 94781
 */
public class ctDAO {
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarySystem?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL_CATEGORY = "SELECT * FROM Bookcategory";
    private static final String DELETE_CATEGORY_SQL = "DELETE FROM Bookcategory WHERE categoryId=?";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
     public List<Model1> selectAllCategory() {
        List<Model1> Category = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String bookCategorys = rs.getString("bookCategorys");
                Category.add(new Model1(categoryId, bookCategorys));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Category;
    }

    public boolean deleteCategory(int categoryId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL)) {
            statement.setInt(1, categoryId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
}
