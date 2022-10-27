package com.example.postviflandmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class District implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @ManyToOne()
    @JoinColumn(name = "province_id")
    private Province province;

    @Column
    private Integer orders;

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp updatedAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private Set<Ward> ward = new HashSet<>();

    @JoinColumn(name = "district_id")
    @OneToMany
    private Set<Product> product;

    @JsonBackReference
    public Set<Product> getProduct() {
        return product;
    }

    public District(Set<Product> product) {
        this.product = product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonManagedReference
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonBackReference
    public Set<Ward> getWard() {
        return ward;
    }

    public void setWard(Set<Ward> ward) {
        this.ward = ward;
    }
}
