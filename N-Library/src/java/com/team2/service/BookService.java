/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.service;

import com.team2.utill.DBConnection;
import com.team2.models.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    
   private static final String INSERT_BOOK_SQL = "INSERT INTO books (bookTitle, bookId, author, bookCategoryId, quantity, description, image,available) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
   private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id = ?"; 
   private static final String UPDATE_BOOK_SQL = "UPDATE books SET bookTitle = ?, bookId = ?, author = ?, bookCategoryId = ?, quantity = ?, description = ?, image = ?, available=? WHERE id = ?";
   private static final String SELECT_BOOK_BY_ID_SQL = "SELECT * FROM book WHERE id = ?";
   private static final String SELECT_ALL_BOOKS_SQL = "SELECT * FROM books";
   private static final String SELECT_BOOK_BY_ID_OR_NAME_SQL = "SELECT * FROM books WHERE Bookid = ? OR title = ?";
    
    public int InsertBook(Books book){
        
        int result = 0;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) 
        {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getBookId());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getCategoryId());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.setString(6, book.getDescription());
            preparedStatement.setString(7, book.getImage());
            preparedStatement.setBoolean(8, book.getAvailable());

            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    
        }
    
    
    
    
    
    
    public Boolean DeleteBook(int id){
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
    
    
    
    
    
  public int UpdateBook(int id, Books book) {
        int result = 0;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getBookId());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getCategoryId());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.setString(6, book.getDescription());
            preparedStatement.setString(7, book.getImage());
            preparedStatement.setInt(8, id);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
  
  
  
  

    public Books showBookById(int bid) {
         Books book = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID_SQL)) {

            preparedStatement.setInt(1, bid);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String bookId = rs.getString("bookId");
                String author = rs.getString("author");
                int categoryId = rs.getInt("categoryId");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Boolean available = rs.getBoolean("available");

                book = new Books(bid,title, bookId, author, categoryId, quantity, description, image,available);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
        
    }
    
    
    

    public List<Books> showBook() {
        List<Books> booksList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS_SQL);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String bookId = rs.getString("bookId");
                String author = rs.getString("author");
                int categoryId = rs.getInt("categoryId");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Boolean available = rs.getBoolean("available");
                Books book = new Books(id,title, bookId, author, categoryId, quantity, description, image,available);
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booksList;
    }
    
    
    
    

    public Books showBookByIdOrName(String bookD) {
       Books book = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID_OR_NAME_SQL)) {

           
            preparedStatement.setString(1, bookD);
            preparedStatement.setString(2, bookD);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String bookId = rs.getString("bookId");
                String author = rs.getString("author");
                int categoryId = rs.getInt("bookCategoryId");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Boolean available = rs.getBoolean("available");

                book = new Books(id,title, bookId, author, categoryId, quantity, description, image,available);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
    


}