package com.example.CRM.controllers;

import com.example.CRM.dto.request.CampaignRequest;
import com.example.CRM.dto.response.CampaignResponse;
import com.example.CRM.entities.Campaign;
import com.example.CRM.services.CampaignServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/campaign")
public class CampaignController {
    private final CampaignServiceImp campaignService;

    @Autowired
    public CampaignController(CampaignServiceImp campaignService)
    {
        this.campaignService=campaignService;
    }

    @GetMapping
    @ResponseBody
    public List<CampaignResponse>getCampaigns()
    {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CampaignResponse getCampaignById(@PathVariable("id") Long id)
    {
        return campaignService.getCampaignById(id);
    }

    @PostMapping
    @ResponseBody
    public Campaign addCampaign(@RequestBody CampaignRequest campaign)
    {
        return campaignService.addCampaign(campaign);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Campaign updateCampaign(@RequestBody CampaignRequest campaign,@PathVariable("id") Long id)
    {
        return campaignService.updateCampaign(campaign,id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCampaignById(@PathVariable("id") Long id)
    {
         campaignService.deleteCampaign(id);
         return ("deleted successfully");
    }

    @GetMapping("byGroup/{id}")
    @ResponseBody
    public List<CampaignResponse>listByGroupId(@PathVariable("id") Long id)
    {
        return campaignService.listByGroupId(id);
    }


    @GetMapping("byProduct/{id}")
    @ResponseBody
    public List<CampaignResponse>listByProductId(@PathVariable("id") Long id)
    {
        return campaignService.listByProductId(id);
    }

}
