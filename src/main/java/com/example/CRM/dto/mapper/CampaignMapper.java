package com.example.CRM.dto.mapper;

import com.example.CRM.dto.response.CampaignResponse;
import com.example.CRM.entities.Campaign;

public class CampaignMapper {

    public CampaignResponse convertToDTO(Campaign campaign){
        CampaignResponse campaignResponse = new CampaignResponse();

        campaignResponse.setId(campaign.getId());
        campaignResponse.setName(campaign.getName());
        campaignResponse.setDescription(campaign.getDescription());
        campaignResponse.setStartdate(campaign.getStartdate());
        campaignResponse.setEnddate(campaign.getEnddate());
        campaignResponse.setExpectedrevenue(campaign.getExpectedrevenue());
        campaignResponse.setBudget(campaign.getBudget());
        campaignResponse.setActualcost(campaign.getActualcost());
        campaignResponse.setEmployeenumber(campaign.getEmployeenumber());
        campaignResponse.setExpectedresponse(campaign.getExpectedresponse());
        campaignResponse.setProductObject(campaign.getProduct());
        campaignResponse.setType(campaign.getType());
        campaignResponse.setStatus(campaign.getStatus());
        campaignResponse.setCreatedat(campaign.getCreatedat());
        campaignResponse.setUpdatedat(campaign.getUpdatedat());
        return campaignResponse;
    }
}
