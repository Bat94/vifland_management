package com.example.postviflandmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardRequestDTO {
    private Long district;
    private String name;
    private String type;
}
