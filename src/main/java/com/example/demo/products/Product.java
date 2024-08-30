package com.example.demo.products;

import jakarta.persistence.*;;

@Entity
@Table

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    @Lob
    private byte[] imagePath;

    public Product() {
    }

    public Product(int id, String n, String d, int q, double p, byte[] image) {
        this.id = id;
        this.name = n;
        this.description = d;
        this.quantity = q;
        this.price = p;
        this.imagePath = image;
    }

    public Product(String n, String d, int q, double p, byte[] image) {
        this.name = n;
        this.description = d;
        this.quantity = q;
        this.price = p;
        this.imagePath = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    // Getter and Setter for password
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    // Getter and Setter for role
    public double getPrice() {
        return price;
    }

    public void setprice(double p) {
        this.price = p;
    }

    public byte[] getimagePath() {
        return imagePath;
    }

    public void setImagePath(byte[] imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + id +
                ",Name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
