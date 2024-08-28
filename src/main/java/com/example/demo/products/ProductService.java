package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository pr;

    @Autowired
    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

    public String saveProduct(Product p) {
        this.pr.save(p);
        return "product saved succesfully";
    }

    public List<Product> getProducts() {
        return this.pr.findAll();
    }

    public String deleteProduct(int id) {
        this.pr.deleteById(id);

        return "product deleted succesfully";
    }

}
