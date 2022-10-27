package com.example.postviflandmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column()
    private String addTags;

    @Column
    private String title;

    @Column
    private String name;

    @Column()
    private String contactName;

    @Column()
    private String nameCompany;

    @Column()
    private Integer phoneNumber;

    @Column
    private String facebook;

    @Column
    private String address;

    @Column
    private String website;

    @Column
    private String email;

    @Column()
    private int postType;

    @Column()
    private Date datetimeStart;

    @Column()
    private Date datetimeEnd;

    @Column()
    private int numberDay;

    @Column
    private int view;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @Column(name = "type")
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JsonManagedReference
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
    @JsonManagedReference
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    @JsonManagedReference
    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddTags() {
        return addTags;
    }

    public void setAddTags(String addTags) {
        this.addTags = addTags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public Date getDatetimeStart() {
        return datetimeStart;
    }

    public void setDatetimeStart(Date datetimeStart) {
        this.datetimeStart = datetimeStart;
    }

    public Date getDatetimeEnd() {
        return datetimeEnd;
    }

    public void setDatetimeEnd(Date datetimeEnd) {
        this.datetimeEnd = datetimeEnd;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Product(long id, String addTags, String title, String name, String contactName, String nameCompany, Integer phoneNumber, String facebook, String address, String website, String email, int postType, Date datetimeStart, Date datetimeEnd, int numberDay, int view, Province province, District district, Ward ward, int type) {
        this.id = id;
        this.addTags = addTags;
        this.title = title;
        this.name = name;
        this.contactName = contactName;
        this.nameCompany = nameCompany;
        this.phoneNumber = phoneNumber;
        this.facebook = facebook;
        this.address = address;
        this.website = website;
        this.email = email;
        this.postType = postType;
        this.datetimeStart = datetimeStart;
        this.datetimeEnd = datetimeEnd;
        this.numberDay = numberDay;
        this.view = view;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.type = type;
    }
}
