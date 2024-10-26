package com.example.demo.products;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository pr;

    @Autowired
    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

   

    public List<Product> getProducts() {
        return this.pr.findAll();
    }

    public String deleteProduct(int id) {
        this.pr.deleteById(id);
        return "product deleted succesfully";
    }

    public String editProduct(Product p) {
        this.pr.save(p);
        return "product edited succesfully";

    }
    public Optional<Product> getProduct(int id){
        return this.pr.findById(id) ; 
    }
    public Product saveProduct(Product p){
        this.pr.save(p) ; 
        return p ; 
    }
    public byte[] getImageById(int id) {
        Optional<Product> product = pr.findById(id);
        return product.map(Product::getImage).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
