package com.team2.service;

import com.team2.controller.utill.DBConnection;
import com.team2.models.Books;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static final String INSERT_QUERY = "INSERT INTO books (title, bookId, author, categoryId, quantity, description, image, available) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE books SET title = ?, bookId = ?, author = ?, categoryId = ?, quantity = ?, description = ?, image = ?, available = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM books WHERE id = ?";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM books";

    // Add a new book
    public int addBook(Books book) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getCategoryId());
            statement.setInt(4, book.getQuantity());
            statement.setString(5, book.getDescription());
            statement.setString(6, book.getImage());
            statement.setInt(7, book.getId());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Update an existing book
    public boolean updateBook(Books book) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getBookId());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getCategoryId());
            statement.setInt(5, book.getQuantity());
            statement.setString(6, book.getDescription());
            statement.setString(7, book.getImage());
            statement.setBoolean(8, book.getAvailable());
            statement.setInt(9, book.getId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all books
    public List<Books> showBooks() {
        List<Books> booksList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Books book = mapResultSetToBook(resultSet);
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    // Get a book by ID
    public Books showBookById(int bookId) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToBook(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete a book
    public boolean deleteBook(int bookId) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, bookId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method to map ResultSet to Book object
    private Books mapResultSetToBook(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String bookId = resultSet.getString("bookId");
        String author = resultSet.getString("author");
        int categoryId = resultSet.getInt("categoryId");
        int quantity = resultSet.getInt("quantity");
        String description = resultSet.getString("description");
        String image = resultSet.getString("image");
        Boolean available = resultSet.getBoolean("available");
        return new Books(id, title, bookId, author, categoryId, quantity, description, image, available);
    }
}
