package com.example.CRM.controllers;

import com.example.CRM.entities.Product;
import com.example.CRM.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImp productServiceImp;
    @Autowired

    public ProductController(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts()
    {
        return productServiceImp.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long id)
    {
        return productServiceImp.getProductById(id);
    }

    @PostMapping
    @ResponseBody
    public Product addProduct(@RequestBody Product product)
    {
        return productServiceImp.addProduct(product);
    }


    @PutMapping
    @ResponseBody
    public Product updateProduct(@RequestBody Product product)
    {
        return productServiceImp.updateProduct(product);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") Long id)
    {
        productServiceImp.deleteProduct(id);
        return ("deleted successfully");
    }
}
