/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 94781
 */
public class Model1 {
    
    private int categoryId;
    private String bookCategorys;

    public Model1(int categoryId, String bookCategorys) {
        this.categoryId=categoryId;
        this.bookCategorys=bookCategorys;
    }
    
     public Model1(String bookCategorys) {
        this.bookCategorys=bookCategorys;
    }
     
     public String getBookCategorys(){
        return bookCategorys;
    }
    
    public void setBookCategorys(String bookCategorys){
        this.bookCategorys=bookCategorys;
    }
    
    public int getCategoryId(){
        return categoryId;
    }
    
    public void setCategoryId(int categoryId){
        this.categoryId=categoryId;
    }
    
}
