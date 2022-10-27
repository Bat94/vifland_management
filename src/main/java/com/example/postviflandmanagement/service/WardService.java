package com.example.postviflandmanagement.service;

import com.example.postviflandmanagement.entity.District;
import com.example.postviflandmanagement.entity.Ward;
import com.example.postviflandmanagement.model.ApiException;
import com.example.postviflandmanagement.model.UpdateWardRequest;
import com.example.postviflandmanagement.model.WardRequestDTO;
import com.example.postviflandmanagement.repository.DistrictRepository;
import com.example.postviflandmanagement.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WardService {
    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private DistrictRepository districtRepository;

//    public List<Ward> findAll() {
//        return wardRepository.findAll();
//    }

    public ResponseEntity<Ward> deleteWard(Long id) {
        Ward ward = wardRepository.getOne(id);
        if(ward==null){
            return ResponseEntity.notFound().build();
        }
        wardRepository.delete(ward);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Ward> updateWard(Long wardId, UpdateWardRequest updateWardRequest) {
        Ward ward = wardRepository.getOne(wardId);
        if (ward == null){
            return ResponseEntity.notFound().build();
        }
        ward.setName(updateWardRequest.getName());
        Ward updateWard = wardRepository.save(ward);
        return ResponseEntity.ok(updateWard);
    }

    public ResponseEntity<Ward> save(WardRequestDTO wardRequestDTO) {
        Optional<District> district = districtRepository.findById(wardRequestDTO.getDistrict());
        if(district.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Ward ward = new Ward();
        ward.setName(wardRequestDTO.getName());
        ward.setDistrict(district.get());
        ward.setType(wardRequestDTO.getType());
        wardRepository.save(ward);
        return ResponseEntity.ok(ward);
    }

    public ResponseEntity<List<Ward>> getWard(Long id) {
        List<Ward> listWard = wardRepository.findAllById(Collections.singleton(id));
        if (listWard.isEmpty()){
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc rong");
        }
            return ResponseEntity.ok(listWard);
    }
}
