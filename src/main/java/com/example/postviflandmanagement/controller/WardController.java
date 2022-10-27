package com.example.postviflandmanagement.controller;

import com.example.postviflandmanagement.entity.Ward;
import com.example.postviflandmanagement.model.UpdateWardRequest;
import com.example.postviflandmanagement.model.WardRequestDTO;
import com.example.postviflandmanagement.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ward")
public class   WardController {
    @Autowired
    private WardService wardService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Ward>> listAllWard(@PathVariable(value = "id")Long id){
        return wardService.getWard(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ward> deleteWard(@PathVariable (value = "id")Long id){
        return wardService.deleteWard(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ward> updateWard(@PathVariable(value = "id")Long wardId,
                                           @Valid @RequestBody UpdateWardRequest updateWardRequest){
        return wardService.updateWard(wardId,updateWardRequest);
    }

    @PostMapping
    public ResponseEntity<Ward> postWard(@Valid @RequestBody WardRequestDTO wardRequestDTO){
        return wardService.save(wardRequestDTO);
    }
}
