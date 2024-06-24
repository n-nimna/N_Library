/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.models;

/**
 *
 * @author kavin
 */
public class Books {

    private int id;
    private String title;
    private String bookId;
    private String author;
    private int categoryId;
    private int quantity;
    private String description;
    private String image;
    private Boolean available;

    public Books(int id, String title, String bookId, String author, int categoryId, int quantity, String description, String image, Boolean available) {
        this.id = id;
        this.title = title;
        this.bookId = bookId;
        this.author = author;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.available = available;
    }

    public Books(String title, String bookId, String author, int categoryId, int quantity, String description, String image, Boolean available) {
        this.title = title;
        this.bookId = bookId;
        this.author = author;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.available = available;

    }

    public Books(int id, String title, String author, int categoryId, int quantity, String description, String image, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
