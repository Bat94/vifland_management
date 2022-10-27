package com.example.postviflandmanagement.login;

import javax.persistence.*;

@Entity
@Table
public class UserRole {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long userId;

    @Column
    private long roleId;

    public UserRole() {
    }

    public UserRole(long id, long userId, long roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
