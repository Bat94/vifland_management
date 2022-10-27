package com.example.postviflandmanagement.login;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class PersistentLogins {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String series;

    @Column
    private String userName;

    @Column
    private String token;

    @Column
    private Timestamp lastUsed;

    public PersistentLogins() {
    }

    public PersistentLogins(String series, String userName, String token, Timestamp lastUsed) {
        this.series = series;
        this.userName = userName;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }
}
