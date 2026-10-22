package com.wusul.sales;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public double price;
    public int quantity;
    
    public Product() {}
}
