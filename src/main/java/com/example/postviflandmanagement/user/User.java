package com.example.postviflandmanagement.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private Date birthday;

    @Column
    private int gender;

    @Column
    private int userType;

    @Column
    private int phone;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String website;

    @Column
    private String facebook;

    @Column
    private String cardId;

    @Column
    private String lastLogin;

    @Column
    private String img;

    @Column
    private String rememberToken;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    @Column
    private int status;

    @Column
    private double wallet;

    @Column
    private double total_cash;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getTotal_cash() {
        return total_cash;
    }

    public void setTotal_cash(double total_cash) {
        this.total_cash = total_cash;
    }

    public User(long id, String username, String password, String fullName, Date birthday, int gender, int userType, int phone, String address, String email, String website, String facebook, String cardId, String lastLogin, String img, String rememberToken, Date createdAt, Date updatedAt, int status, double wallet, double total_cash) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.userType = userType;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.website = website;
        this.facebook = facebook;
        this.cardId = cardId;
        this.lastLogin = lastLogin;
        this.img = img;
        this.rememberToken = rememberToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.wallet = wallet;
        this.total_cash = total_cash;
    }

}
