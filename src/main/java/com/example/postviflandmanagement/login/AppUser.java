package com.example.postviflandmanagement.login;

import javax.persistence.*;

@Entity
@Table()
public class AppUser {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column()
    private String userName;

    @Column
    private String encrytedPassword;

    @Column
    private byte enabled;

    public AppUser() {
    }

    public AppUser(long id, String userName, String encrytedPassword, byte enabled) {
        this.id = id;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }
}
