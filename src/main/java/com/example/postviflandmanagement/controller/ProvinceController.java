package com.example.postviflandmanagement.controller;

import com.example.postviflandmanagement.entity.Province;
import com.example.postviflandmanagement.model.ProvinceRequestDTO;
import com.example.postviflandmanagement.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping()
    public ResponseEntity<List<Province>> listAllProvince(){
        return provinceService.getListProvince();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Province> deleteProvince(@PathVariable(value = "id")Long provinceId){
        return provinceService.deleteProvince(provinceId);
    }
    @PutMapping("{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable(value = "id")Long id,
                                                           @Valid @RequestBody ProvinceRequestDTO provinceRequestDTO){

        return provinceService.updateProvince(id,provinceRequestDTO);
    }

    @PostMapping()
    public ResponseEntity<Province> postProvince(@Valid @RequestBody ProvinceRequestDTO provinceRequestDTO){

        return provinceService.save(provinceRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getprovince(@PathVariable(value = "id") Long id){
        return provinceService.getIdProvince(id);
    }
}
