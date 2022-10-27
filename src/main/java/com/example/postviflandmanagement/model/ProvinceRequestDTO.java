package com.example.postviflandmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceRequestDTO {
    private Long id;
    private String content;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int orders;
}
