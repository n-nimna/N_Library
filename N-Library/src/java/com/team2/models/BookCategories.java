package com.team2.models;

public class BookCategories {

    private int bcId;
    private int genId; // Genre ID
    private String categoryName;

    public BookCategories() {
    }

    public BookCategories(int bcId, int genId, String categoryName) {
        this.bcId = bcId;
        this.genId = genId;
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public int getBcId() {
        return bcId;
    }

    public void setBcId(int bcId) {
        this.bcId = bcId;
    }

    public int getGenId() {
        return genId;
    }

    public void setGenId(int genId) {
        this.genId = genId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}