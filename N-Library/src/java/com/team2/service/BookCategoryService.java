package com.team2.service;

import com.team2.controller.utill.DBConnection;
import com.team2.models.BookCategories;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryService {

    private static final String INSERT_QUERY = "INSERT INTO book_category (genId, categoryName) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE book_category SET genId = ?, categoryName = ? WHERE bcId = ?";
    private static final String DELETE_QUERY = "DELETE FROM book_category WHERE bcId = ?";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM book_category WHERE bcId = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM book_category";

    // Add a new BookCategory
    public int addBookCategory(BookCategories bookCategory) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, bookCategory.getGenId());
            statement.setString(2, bookCategory.getCategoryName());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Get the generated bcId
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Indicate failure
    }

    // Update an existing BookCategory
    public boolean updateBookCategory(BookCategories bookCategory) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, bookCategory.getGenId());
            statement.setString(2, bookCategory.getCategoryName());
            statement.setInt(3, bookCategory.getBcId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all BookCategories
    public List<BookCategories> showBookCategories() {
        List<BookCategories> bookCategoriesList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookCategories bookCategory = mapResultSetToBookCategory(resultSet);
                bookCategoriesList.add(bookCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategoriesList;
    }

    // Get a BookCategory by ID
    public BookCategories showBookCategoryById(int bcId) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, bcId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToBookCategory(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete a BookCategory
    public boolean deleteBookCategory(int bcId) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, bcId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method to map ResultSet to BookCategory object
    private BookCategories mapResultSetToBookCategory(ResultSet resultSet) throws SQLException {
        int bcId = resultSet.getInt("bcId");
        int genId = resultSet.getInt("genId");
        String categoryName = resultSet.getString("categoryName");
        return new BookCategories(bcId, genId, categoryName);
    }
}