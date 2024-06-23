package com.team2.models;

public class BookCategories {

    private int bcId;
    private String categoryName;

    public BookCategories() {
    }

    public BookCategories(int bcId, String categoryName) {
        this.bcId = bcId;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public int getBcId() {
        return bcId;
    }

    public void setBcId(int bcId) {
        this.bcId = bcId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
