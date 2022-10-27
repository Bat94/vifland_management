package com.example.postviflandmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictRequestDTO {
    private String name;
    private int orders;
    private long province;
}
