package com.example.CRM.services;

import com.example.CRM.dto.request.CampaignRequest;
import com.example.CRM.entities.*;
import com.example.CRM.repositories.CampaignRepository;
import com.example.CRM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImp implements CampaignService{

    private final CampaignRepository campaignRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CampaignServiceImp(CampaignRepository campaignRepository,ProductRepository productRepository) {
        this.campaignRepository = campaignRepository;
        this.productRepository=productRepository;
    }


    @Override
    public Campaign addCampaign(CampaignRequest campaign) {

        Product product = productRepository.findById(campaign.getProductId()).orElse(null);

        Campaign cpm = new Campaign();
        cpm.setName(campaign.getName());
        cpm.setDescription(campaign.getDescription());
        cpm.setStartdate(campaign.getStartdate());
        cpm.setEnddate(campaign.getEnddate());
        cpm.setExpectedrevenue(campaign.getExpectedrevenue());
        cpm.setBudget(campaign.getBudget());
        cpm.setActualcost(campaign.getActualcost());
        cpm.setEmployeenumber(campaign.getEmployeenumber());
        cpm.setExpectedresponse(campaign.getExpectedresponse());
        cpm.setType(campaign.getType());
        cpm.setStatus(campaign.getStatus());
        cpm.setProduct(product);

        return campaignRepository.save(cpm);
    }

    @Override
    public Campaign updateCampaign(CampaignRequest campaign,Long id) {

        Product product = productRepository.findById(campaign.getProductId()).orElse(null);
        Campaign cpm = campaignRepository.findById(id).orElse(null);

        cpm.setName(campaign.getName());
        cpm.setDescription(campaign.getDescription());
        cpm.setStartdate(campaign.getStartdate());
        cpm.setEnddate(campaign.getEnddate());
        cpm.setExpectedrevenue(campaign.getExpectedrevenue());
        cpm.setBudget(campaign.getBudget());
        cpm.setActualcost(campaign.getActualcost());
        cpm.setEmployeenumber(campaign.getEmployeenumber());
        cpm.setExpectedresponse(campaign.getExpectedresponse());
        cpm.setType(campaign.getType());
        cpm.setStatus(campaign.getStatus());
        cpm.setProduct(product);

        return campaignRepository.save(cpm);

    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id).orElse(null);
    }

    @Override
    public List<Campaign> getAllCampaigns() {

        return campaignRepository.findAll();
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }

   /* @Override
    public List<Campaign> getByProduct(Long productId) {
        return campaignRepository.findByProduct(productId);
    }*/
}
