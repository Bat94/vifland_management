package com.example.postviflandmanagement.login;

import javax.persistence.*;

@Entity
@Table
public class AppRole {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String roleName;

    public AppRole() {
    }

    public AppRole(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
