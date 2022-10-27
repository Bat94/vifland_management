package com.example.postviflandmanagement.model;

import javax.validation.constraints.NotEmpty;

public class UpdateDistrictRequest {

    @NotEmpty()
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
