package com.example.postviflandmanagement.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateProvinceRequest {

    @NotEmpty()
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
