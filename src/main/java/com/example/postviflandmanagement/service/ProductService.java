package com.example.postviflandmanagement.service;

import com.example.postviflandmanagement.entity.District;
import com.example.postviflandmanagement.entity.Product;
import com.example.postviflandmanagement.entity.Province;
import com.example.postviflandmanagement.entity.Ward;
import com.example.postviflandmanagement.model.ApiException;
import com.example.postviflandmanagement.model.ProductRequestDTO;
import com.example.postviflandmanagement.model.UpdateProductRequest;
import com.example.postviflandmanagement.repository.DistrictRepository;
import com.example.postviflandmanagement.repository.ProductRepository;
import com.example.postviflandmanagement.repository.ProvinceRepository;
import com.example.postviflandmanagement.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public ResponseEntity<Product> deleteProduct(Long productId) {
        Product product = productRepository.getOne(productId);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Product> updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.getOne(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        product.setName(updateProductRequest.getName());
        Product updateProduct = productRepository.save(product);
        return ResponseEntity.ok(updateProduct);
    }

    public ResponseEntity<Product> postProduct(ProductRequestDTO productRequestDTO) {
        Optional<Ward> ward = wardRepository.findById(productRequestDTO.getWard());
        Optional<District> district = districtRepository.findById(productRequestDTO.getDistrict());
        Optional<Province> province = provinceRepository.findById(productRequestDTO.getProvince());
        if (ward.isEmpty() || district.isEmpty() || province.isEmpty()){
            throw new ApiException(HttpStatus.NOT_FOUND,"k duoc trong");
        }
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setWard(ward.get());
        product.setDistrict(district.get());
        product.setProvince(province.get());
        product.setPhoneNumber(productRequestDTO.getPhoneNumber());
        product.setPostType(productRequestDTO.getPostType());
        product.setType(productRequestDTO.getType());
        product.setView(productRequestDTO.getView());
        product.setNumberDay(productRequestDTO.getNumberDay());
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<List<Product>> getProduct() {
        List<Product> product = productRepository.findAll();
        if(product.isEmpty()){
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc null");
        }
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<List<Product>> getAllProduct(int postType) {
        List<Product> listProduct = productRepository.findByPostType(postType);
        return ResponseEntity.ok(listProduct);
    }

    public ResponseEntity<List<Product>> getListProduct(int type) {
        List<Product> listAllProduct = productRepository.findByType(type);
        return ResponseEntity.ok(listAllProduct);
    }
}
