package com.example.CRM.services;

import com.example.CRM.entities.Campaign;
import com.example.CRM.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImp implements CampaignService{

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImp(CampaignRepository campaignRepository)
    {
        this.campaignRepository=campaignRepository;
    }

    @Override
    public Campaign addCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign updateCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
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
}
