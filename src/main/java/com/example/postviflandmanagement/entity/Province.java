package com.example.postviflandmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private Integer orders;

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp updatedAt;

    @Column
    private String content;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Set<District> district;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Set<Product> product;

    public Set<Product> getProduct() {
        return product;
    }

    @JsonBackReference
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonBackReference
    public Set<District> getDistrict() {
        return district;
    }

    public void setDistrict(Set<District> district) {
        this.district = district;
    }
}
