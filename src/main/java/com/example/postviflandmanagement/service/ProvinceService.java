package com.example.postviflandmanagement.service;

import com.example.postviflandmanagement.entity.Province;
import com.example.postviflandmanagement.model.ApiException;
import com.example.postviflandmanagement.model.ProvinceRequestDTO;
import com.example.postviflandmanagement.repository.ProvinceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public ResponseEntity<Province> deleteProvince(Long provinceId) {
        Province province = provinceRepository.getOne(provinceId);
        if (province == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc null");
        }
        provinceRepository.delete(province);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Province> updateProvince(Long id, @Valid ProvinceRequestDTO provinceRequestDTO) {
        Optional<Province> provinceOptional = provinceRepository.findById(id);
        if (!provinceOptional.isEmpty()) {
            provinceRequestDTO.getName();
            return ResponseEntity.ok().build();
        } else {
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc rong");
        }

    }

    public ResponseEntity<Province> save(@Valid ProvinceRequestDTO provinceRequestDTO) {
        Province province = new Province();
        BeanUtils.copyProperties(provinceRequestDTO, province);
        province = provinceRepository.save(province);
        return ResponseEntity.ok(province);
    }

    public ResponseEntity<List<Province>> getListProvince() {
        List<Province> province = provinceRepository.findAll();
        if (province.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc rong");
        }
        return new ResponseEntity<>(province, HttpStatus.OK);

    }

    public ResponseEntity<Province> getIdProvince(Long id) {
        Optional<Province> province = provinceRepository.findById(id);
        if (province.isEmpty()) {
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc rong");
        }
        return new ResponseEntity(province, HttpStatus.OK);
    }
}
