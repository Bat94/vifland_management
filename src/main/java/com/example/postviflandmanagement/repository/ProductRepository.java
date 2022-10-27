package com.example.postviflandmanagement.repository;

import com.example.postviflandmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT product FROM Product product where product.postType = ?1")
    List<Product> findByPostType(int postType);

    @Query("SELECT product FROM Product product where product.type = ?1")
    List<Product> findByType(int type);

    Product getOneById(Long id);
}
