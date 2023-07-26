package com.example.CRM.services;

import com.example.CRM.entities.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public void deleteProduct(Long id);
}
