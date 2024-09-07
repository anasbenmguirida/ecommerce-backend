package com.example.demo.products;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> addProduct(@RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile image) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setImage(image.getBytes());
        ps.saveProduct(product);
        return ResponseEntity.ok("product saved ");
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
