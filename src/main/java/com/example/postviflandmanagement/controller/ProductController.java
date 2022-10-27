package com.example.postviflandmanagement.controller;

import com.example.postviflandmanagement.entity.Product;
import com.example.postviflandmanagement.model.ProductRequestDTO;
import com.example.postviflandmanagement.model.UpdateProductRequest;
import com.example.postviflandmanagement.service.IProductService;
import com.example.postviflandmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vifland")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = ("/product/"),method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProduct(){
       return productService.getProduct();
    }

    @RequestMapping(value = ("/product/{id}"),method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Long productId){
        return productService.deleteProduct(productId);
    }

    @RequestMapping(value = ("/product/{id}"),method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id")Long id,
                                                 @Valid @RequestBody UpdateProductRequest updateProductRequest){
        return productService.updateProduct(id,updateProductRequest);
    }

    @RequestMapping(value = ("/product/"),method = RequestMethod.POST)
    public ResponseEntity<Product> postProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        return productService.postProduct(productRequestDTO);
    }

    @RequestMapping(value = ("/product"),method = RequestMethod.GET)
    public ResponseEntity <List<Product>> getProduct(@RequestParam(required = false)int postType){
        return productService.getAllProduct(postType);
    }

    @RequestMapping(value = ("/productType"),method = RequestMethod.GET)
    public ResponseEntity <List<Product>> getListProduct(@RequestParam(required = false)int type){
        return productService.getListProduct(type);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductId(@PathVariable(value = "id")Long id){
        return iProductService.getProductId(id);
    }
}
