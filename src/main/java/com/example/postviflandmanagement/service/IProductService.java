package com.example.postviflandmanagement.service;

import com.example.postviflandmanagement.entity.Product;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity<Product> getProductId(Long id);
}
