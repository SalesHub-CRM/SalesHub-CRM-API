package com.example.CRM.controllers;

import com.example.CRM.dto.request.ProductRequest;
import com.example.CRM.entities.Product;
import com.example.CRM.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@CrossOrigin(origins = "http://localhost:3000")
*/
//@CrossOrigin("*")
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
    public Product addProduct(@RequestBody ProductRequest product)
    {
        return productServiceImp.addProduct(product);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Product updateProduct(@RequestBody ProductRequest product,@PathVariable("id") Long id)
    {
        return productServiceImp.updateProduct(product,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") Long id)
    {
        productServiceImp.deleteProduct(id);
        return ("deleted successfully");
    }
}
