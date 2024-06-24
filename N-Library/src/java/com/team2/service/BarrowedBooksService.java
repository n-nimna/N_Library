/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.service;

import com.team2.controller.utill.DBConnection;
import com.team2.models.BarrowedBooks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BarrowedBooksService {

    private static final String INSERT_BOOK_SQL = "INSERT INTO BarrowBook (userId, bookId, barrowDate, returnDate) VALUES ( ?, ?, ?, ?)";
    private static final String DELETE_BOOK_SQL = "DELETE FROM barrowbook WHERE id = ?"; 
    private static final String SELECT_ALL_BORROWED_BOOKS_SQL = "SELECT * FROM barrowbook";
    private static final String SELECT_BORROWED_BOOK_BY_BOOK_ID_SQL = "SELECT id, userId, bookId, barrowDate, returnDate FROM barrowbook WHERE bookId = ?";


    public int addBarrowBook(BarrowedBooks barrowbooks) {
        int result = 0;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {

            // Set the parameters for the PreparedStatement
       
            preparedStatement.setInt(1, barrowbooks.getUserId());
            preparedStatement.setString(2, barrowbooks.getBookId());
            preparedStatement.setDate(3, new java.sql.Date(barrowbooks.getBorrowDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(barrowbooks.getReturnDate().getTime()));

            // Execute the update
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    
    }

    public Boolean deleteBarrowBook(int id) {
        boolean rowDeleted = false;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {

            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    public List<BarrowedBooks> showBarrowedBook() {
       List<BarrowedBooks> barrowedBooksList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BORROWED_BOOKS_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("userId");
                String bookId = resultSet.getString("bookId");
                Date borrowDate = resultSet.getDate("barrowDate");
                Date returnDate = resultSet.getDate("returnDate");

                BarrowedBooks barrowedBook = new BarrowedBooks(id, userId, bookId, borrowDate, returnDate);
                barrowedBooksList.add(barrowedBook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barrowedBooksList; 
    }

    public BarrowedBooks showBarrowedBookByBookId(String bookId) {
        BarrowedBooks barrowedBook = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROWED_BOOK_BY_BOOK_ID_SQL)) {

            // Set the parameter for the PreparedStatement
            preparedStatement.setString(1, bookId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("userId");
                Date borrowDate = resultSet.getDate("barrowDate");
                Date returnDate = resultSet.getDate("returnDate");

                barrowedBook = new BarrowedBooks(id, userId, bookId, borrowDate, returnDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barrowedBook;
    }
    
}
