package com.example.CRM.controllers;

import com.example.CRM.dto.request.GroupRequest;
import com.example.CRM.dto.response.GroupResponse;
import com.example.CRM.entities.Group;
import com.example.CRM.services.GroupServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupServiceImp groupServiceImp;

    @Autowired
    public GroupController(GroupServiceImp groupServiceImp) {
        this.groupServiceImp = groupServiceImp;
    }

    @GetMapping("/listGroups/{id}")
    @ResponseBody
    public List<GroupResponse> getAllgroupsByAdmin(@PathVariable("id") Long id)
    {
        return groupServiceImp.getAllGroupsByAdmin(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public GroupResponse getGroupById(@PathVariable("id") Long id)
    {
        return groupServiceImp.getGroupById(id);
    }

    @PostMapping
    @ResponseBody
    public Group addGroup(@RequestBody GroupRequest group)
    {
        return groupServiceImp.addGroup(group);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Group updateGroup(@RequestBody GroupRequest group, @PathVariable("id") Long id)
    {
        return groupServiceImp.updateGroup(group,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteGroup(@PathVariable("id") Long id)
    {
        groupServiceImp.deleteGroup(id);
        return ("deleted successfully");
    }

    @GetMapping("/countGroups/{id}")
    @ResponseBody
    public int getGroupCountByAdmin(@PathVariable("id") Long id)
    {
        return groupServiceImp.getGroupCountByAdmin(id);
    }
}
