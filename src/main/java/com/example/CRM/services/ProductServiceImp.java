package com.example.CRM.services;

import com.example.CRM.dto.request.ProductRequest;
import com.example.CRM.entities.Group;
import com.example.CRM.entities.Opportunity;
import com.example.CRM.entities.Product;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.repositories.OpportunityRepository;
import com.example.CRM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;
    private final GroupRepository groupRepository;
    @Autowired
    public ProductServiceImp(ProductRepository productRepository, GroupRepository groupRepository)
    {
        this.productRepository=productRepository;
        this.groupRepository=groupRepository;
    }

    @Override
    public Product addProduct(ProductRequest product) {
        Product prdt=new Product();
        prdt.setName(product.getName());
        prdt.setDescription(product.getDescription());
        prdt.setPrice(product.getPrice());
        prdt.setProductionstart(product.getProductionstart());
        prdt.setProductionend(product.getProductionend());
        prdt.setOwnerId(product.getOwnerId());
        return productRepository.save(prdt);
    }

    @Override
    public Product updateProduct(ProductRequest product,Long id) {
        Product prdt=productRepository.findById(id).orElse(null);
        prdt.setName(product.getName());
        prdt.setDescription(product.getDescription());
        prdt.setPrice(product.getPrice());
        prdt.setProductionstart(product.getProductionstart());
        prdt.setProductionend(product.getProductionend());
        return productRepository.save(prdt);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> fetchByOwnerGroup(Long groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);

        return productRepository.findByOwnerId(group.getAdminId());
    }

    @Override
    public List<Product> fetchByOwnerId(Long ownerId) {
        return productRepository.findByOwnerId(ownerId);
    }

    /*@Override
    public List<Product> getByGroup(Long groupId) {
        return productRepository.findByOpportunity_Client_Group_Id(groupId);
    }*/
}
