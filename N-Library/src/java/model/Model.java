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
public class Model {
    
    private int id;
    private int Bookid;
    private String bookCategory;
    private String bookTitle;
    private String author;
    private String description;
    private int quantity;
    private String image;
    private boolean available;
    private int bookId;
    private int userId;
    private String barrowedDate;
    private String returnDate;
    private boolean Return;
    
    //Book

    public Model(int id, String bookCategory, String bookTitle, String image, String author, boolean available, String description, int quantity) {
        this.id=id;
        this.bookCategory=bookCategory;
        this.bookTitle=bookTitle;
        this.image=image;
        this.author=author;
        this.available=available;
        this.description=description;
        this.quantity=quantity;
    }

    public Model(int id, int Bookid, String bookCategory, String bookTitle, String author, String description, int quantity, String image, boolean available) {
        this.id=id;
        this.Bookid=Bookid;
        this.bookCategory=bookCategory;
        this.bookTitle=bookTitle;
        this.image=image;
        this.author=author;
        this.description=description;
        this.quantity=quantity;
        this.available=available;
    }
    
    //Barrowed

    public Model(int bookId, String barrowedDate, String returnDate, int userId, boolean Return) {
        this.bookId=bookId;
        this.userId=userId;
        this.barrowedDate=barrowedDate;
        this.returnDate=returnDate;
        this.Return=Return;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    //BarrowedTable
    
    public int getbookId(){
        return bookId;
    }
    
    public void setbookId(int bookId){
        this.bookId=bookId;
    }
    
    public int getuserId(){
        return userId;
    }
    
    public void setuserId(int userId){
        this.userId=userId;
    }
    
    public String getbarrowedDate(){
        return barrowedDate;
    }
    
    public void setbarrowedDate(String barrowedDate){
        this.barrowedDate=barrowedDate;
    }
    
    public String getreturnDate(){
        return returnDate;
    }
    
    public void setreturnDate(String returnDate){
        this.returnDate=returnDate;
    }
    
    public boolean getReturn(){
        return Return;
    }
    
    public void setReturn(boolean Return){
        this.Return=Return;
    }
    
    //BookTable
    
    public int getBookid(){
        return Bookid;
    }
    
    public void setBookid(int Bookid){
        this.Bookid=Bookid;
    }
    
    public String getBookCategory(){
        return bookCategory;
    }
    
    public void setBookCategory(String bookCategory){
        this.bookCategory=bookCategory;
    }
    
    public String getBookTitle(){
        return bookTitle;
    }
    
    public void setBookTitle(String bookTitle){
        this.bookTitle=bookTitle;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author=author;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image=image;
    }
    
    public boolean getAvailable(){
        return available;
    }
    
    public void setAvailable(boolean available){
        this.available=available;
    }
    
    
    
    
}
