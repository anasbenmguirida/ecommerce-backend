package com.example.demo.products;

import java.io.IOException;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(path = "api")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {

    private final ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }
    @GetMapping("/product-details/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        return this.ps.getProduct(id) ; 
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return this.ps.getProducts();
    }

    @PostMapping("/save-product")
    public ResponseEntity<Product> createProduct(@RequestParam("image") MultipartFile image,
                                               @RequestParam("name") String name,
                                               @RequestParam("description") String description,
                                               @RequestParam("quantity") int quantity,
                                               @RequestParam("price") Double price) {
        try {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setQuantity(quantity);
            product.setImage(image.getBytes());
            
            Product savedProduct = ps.saveProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return this.ps.deleteProduct(id);
    }

    @PostMapping("/edit-product")
    public String editProduct(@RequestBody Product p) {
        return this.ps.editProduct(p);
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id) {
        byte[] image = this.ps.getImageById(id);
        System.out.println("im here ");
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG) // Adjust this depending on your image type
            .body(image);
    }

}
