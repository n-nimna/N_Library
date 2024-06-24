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

/**
 *
 * @author 94781
 */
public class DbDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarySystem?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM Book WHERE id=?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM Book";
    private static final String SELECT_ALL_BARROWED = "SELECT * FROM borrowedbookes";
    
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
    
    public Model selectBook(int id) {
        Model todo = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Bookid = rs.getInt("Bookid");
                String bookCategory = rs.getString("bookCategory");
                String bookTitle = rs.getString("bookTitle");
                String author = rs.getString("author");
                String image = rs.getString("image");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                boolean available = rs.getBoolean("available");
                todo = new Model(id, Bookid, bookCategory, bookTitle, author, description, quantity, image, available);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public List<Model> selectAllBooks() {
        List<Model> Book = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookCategory = rs.getString("bookCategory");
                String bookTitle = rs.getString("bookTitle");
                String image = rs.getString("image");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                boolean available = rs.getBoolean("available");
                Book.add(new Model(id, bookCategory, bookTitle, image, author, available, description, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Book;
    }

    public List<Model> selectAllBarrowed() {
        List<Model> Book = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BARROWED)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("userId");
                int bookId = rs.getInt("bookId");
                String barrowedDate = rs.getString("barrowedDate");
                String returnDate = rs.getString("returnDate");;
                boolean Return = rs.getBoolean("Return");
                Book.add(new Model(bookId, barrowedDate, returnDate, userId, Return));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Book;
    }
    
    
}
