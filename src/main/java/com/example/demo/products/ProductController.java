package com.example.demo.products;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "api")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {

    private final ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return this.ps.getProducts();
    }

    @PostMapping("/save-product")
    public ResponseEntity<Product> addProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile imageFile) throws IOException {
        Product product = ps.saveProduct(name, description, quantity, price, imageFile);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return this.ps.deleteProduct(id);
    }

    @PostMapping("/edit-product")
    public String editProduct(@RequestBody Product p) {
        return this.ps.editProduct(p);
    }

}
