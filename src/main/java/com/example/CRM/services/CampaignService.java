package com.example.CRM.services;

import com.example.CRM.dto.request.CampaignRequest;
import com.example.CRM.dto.response.CampaignResponse;
import com.example.CRM.entities.Campaign;

import java.util.List;

public interface CampaignService {
    public Campaign addCampaign (CampaignRequest campaign);
    public Campaign updateCampaign (CampaignRequest campaign, Long id);
    public CampaignResponse getCampaignById (Long id);
    public List<CampaignResponse>getAllCampaigns();
    public void deleteCampaign (Long id);
    public List<CampaignResponse>listByProductId(Long productId);
    public List<CampaignResponse>listByGroupId(Long groupId);
}
