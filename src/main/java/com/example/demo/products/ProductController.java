package com.example.demo.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String saveProduct(@RequestBody Product product) {
        return this.ps.saveProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return this.ps.deleteProduct(id);
    }

}
