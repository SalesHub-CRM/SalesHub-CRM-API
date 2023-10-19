package com.example.CRM.services;

import com.example.CRM.dto.mapper.CampaignMapper;
import com.example.CRM.dto.request.CampaignRequest;
import com.example.CRM.dto.response.CampaignResponse;
import com.example.CRM.entities.*;
import com.example.CRM.repositories.CampaignRepository;
import com.example.CRM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public CampaignResponse getCampaignById(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        CampaignMapper campaignMapper = new CampaignMapper();
        return campaignMapper.convertToDTO(campaign);
    }

    @Override
    public List<CampaignResponse> getAllCampaigns() {

        List<Campaign>campaigns = campaignRepository.findAll();
        List<CampaignResponse>campaignResponses=new ArrayList<>();
        CampaignMapper campaignMapper = new CampaignMapper();
        for(Campaign campaign : campaigns){
            CampaignResponse campaignResponse = campaignMapper.convertToDTO(campaign);
            campaignResponses.add(campaignResponse);
        }
        return campaignResponses;
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }

    @Override
    public List<CampaignResponse> listByProductId(Long productId) {
        List<Campaign>campaigns = campaignRepository.findByProduct_Id(productId);
        List<CampaignResponse>campaignResponses=new ArrayList<>();
        CampaignMapper campaignMapper = new CampaignMapper();
        for(Campaign campaign : campaigns){
            CampaignResponse campaignResponse = campaignMapper.convertToDTO(campaign);
            campaignResponses.add(campaignResponse);
        }
        return campaignResponses;
    }

    @Override
    public List<CampaignResponse> listByGroupId(Long groupId) {
        List<Campaign>campaigns = campaignRepository.findCampaignsByGroupId(groupId);
        List<CampaignResponse>campaignResponses=new ArrayList<>();
        CampaignMapper campaignMapper = new CampaignMapper();
        for(Campaign campaign : campaigns){
            CampaignResponse campaignResponse = campaignMapper.convertToDTO(campaign);
            campaignResponses.add(campaignResponse);
        }
        return campaignResponses;
    }

}
