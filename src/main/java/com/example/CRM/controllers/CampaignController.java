package com.example.CRM.controllers;

import com.example.CRM.entities.Campaign;
import com.example.CRM.services.CampaignServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Campaign>getCampaigns()
    {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Campaign getCampaignById(@PathVariable("id") Long id)
    {
        return campaignService.getCampaignById(id);
    }

    @PostMapping
    @ResponseBody
    public Campaign addCampaign(@RequestBody Campaign campaign)
    {
        return campaignService.addCampaign(campaign);
    }

    @PutMapping
    @ResponseBody
    public Campaign updateCampaign(@RequestBody Campaign campaign)
    {
        return campaignService.updateCampaign(campaign);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCampaignById(@PathVariable("id") Long id)
    {
         campaignService.deleteCampaign(id);
         return ("deleted successfully");
    }

}
