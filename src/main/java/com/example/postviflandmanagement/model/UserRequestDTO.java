package com.example.postviflandmanagement.model;

public class UserRequestDTO {
    private String userName;
    private String passWord;
    private int phone;

    public UserRequestDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public UserRequestDTO(String userName, String passWord, int phone) {
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
    }
}
