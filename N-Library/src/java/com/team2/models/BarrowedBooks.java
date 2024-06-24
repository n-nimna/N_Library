/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.models;

import java.util.Date;

/**
 *
 * @author kavin
 */
public class BarrowedBooks {
    
    private int id;
    private int userId;
    private String bookId;
    private Date barrowDate;
    private Date returnDate;
    
     public BarrowedBooks() {
    }

    // All-arguments constructor
    public BarrowedBooks(int id, int userId, String bookId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.barrowDate = borrowDate;
        this.returnDate = returnDate;
    }
    
    
      public BarrowedBooks( int userId, String bookId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.barrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return barrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.barrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    
}
