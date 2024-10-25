package com.example.demo.products;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
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

    public Product saveProduct(String name, String description, int quantity, double price, MultipartFile imageFile)
            throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setImage(imageFile.getBytes()); // Convert the image to byte[]

        return pr.save(product);
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
    public byte[] getImageById(int id) {
        Optional<Product> product = pr.findById(id);
        return product.map(Product::getImage).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
