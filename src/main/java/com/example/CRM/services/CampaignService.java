package com.example.CRM.services;

import com.example.CRM.entities.Campaign;

import java.util.List;

public interface CampaignService {
    public Campaign addCampaign (Campaign campaign);
    public Campaign updateCampaign (Campaign campaign);
    public Campaign getCampaignById (Long id);
    public List<Campaign>getAllCampaigns();
    public void deleteCampaign (Long id);
}
