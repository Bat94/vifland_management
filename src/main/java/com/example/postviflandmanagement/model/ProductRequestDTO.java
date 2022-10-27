package com.example.postviflandmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private long district;
    private long province;
    private String name;
    private long ward;
    private int phoneNumber;
    private String email;
    private int postType;
    private int numberDay;
    private int view;
    private int type;
}
