package com.example.postviflandmanagement.service;

import com.example.postviflandmanagement.entity.District;
import com.example.postviflandmanagement.entity.Province;
import com.example.postviflandmanagement.model.ApiException;
import com.example.postviflandmanagement.model.DistrictRequestDTO;
import com.example.postviflandmanagement.model.UpdateDistrictRequest;
import com.example.postviflandmanagement.repository.DistrictRepository;
import com.example.postviflandmanagement.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<District> findAll() {
        return districtRepository.findAll();
    }

    public ResponseEntity<District> deleteDistrict(Long id) {
        District district = districtRepository.getOne(id);
        if(district == null){
            return ResponseEntity.notFound().build();
        }
            districtRepository.delete(district);
            return ResponseEntity.ok().build();
    }

    public ResponseEntity<District> updateDistrict(Long id, UpdateDistrictRequest updateDistrictRequest) {
        District district = districtRepository.getOne(id);
        if(district == null){
            return ResponseEntity.notFound().build();
        }
        district.setName(updateDistrictRequest.getName());
        District updateDictrict = districtRepository.save(district);
        return ResponseEntity.ok(updateDictrict);
    }

    public ResponseEntity<District> save(@Valid DistrictRequestDTO districtRequestDTO) {
        Optional<Province> province = provinceRepository.findById(districtRequestDTO.getProvince());
        if (province.isEmpty()){
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc rong");
        }
        District postDistrict = new District();
        postDistrict.setName(districtRequestDTO.getName());
        postDistrict.setOrders(districtRequestDTO.getOrders());
        postDistrict.setProvince(province.get());
        districtRepository.save(postDistrict);
        return ResponseEntity.ok(postDistrict);
    }
}
