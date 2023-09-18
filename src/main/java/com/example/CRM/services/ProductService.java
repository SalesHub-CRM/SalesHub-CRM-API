package com.example.CRM.services;

import com.example.CRM.dto.request.ProductRequest;
import com.example.CRM.entities.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(ProductRequest product);
    public Product updateProduct(ProductRequest product,Long id);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public void deleteProduct(Long id);
    /*public List<Product>getByGroup(Long groupId);*/
}
