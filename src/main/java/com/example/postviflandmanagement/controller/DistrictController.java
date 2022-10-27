package com.example.postviflandmanagement.controller;

import com.example.postviflandmanagement.entity.District;
import com.example.postviflandmanagement.model.DistrictRequestDTO;
import com.example.postviflandmanagement.model.UpdateDistrictRequest;
import com.example.postviflandmanagement.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<District>> listAllDistrict(){
        List<District> listDistrict = districtService.findAll();
        if(listDistrict.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listDistrict,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<District> deleteDistrict(@PathVariable(value = "id") Long id){
        return districtService.deleteDistrict(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable (value = "id") Long id,
                                                    @Valid @RequestBody UpdateDistrictRequest updateDistrictRequest){
        return districtService.updateDistrict(id,updateDistrictRequest);
    }
    @PostMapping
    public ResponseEntity<District> postDistrict(@Valid @RequestBody DistrictRequestDTO districtRequestDTO){
        return districtService.save(districtRequestDTO);
    }
}
