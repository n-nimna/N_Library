package com.team2.models;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String userNic;
    private String image;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private boolean active;
    private String userType;

    // Constructors
    public User() {
    }

    public User(int userId, String firstName, String lastName, String userNic, String image, String email, String phoneNumber, String address, String password, boolean active, String userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNic = userNic;
        this.image = image;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.active = active;
        this.userType = userType;
    }

    public User(String firstName, String lastName, String userNic, String image, String email, String phoneNumber, String address, int userId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNic = userNic;
        this.image = image;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserNic() {
        return userNic;
    }

    public void setUserNic(String userNic) {
        this.userNic = userNic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
