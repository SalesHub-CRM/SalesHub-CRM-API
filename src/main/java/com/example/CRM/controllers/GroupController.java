package com.example.CRM.controllers;

import com.example.CRM.entities.Group;
import com.example.CRM.services.GroupServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupServiceImp groupServiceImp;

    @Autowired
    public GroupController(GroupServiceImp groupServiceImp) {
        this.groupServiceImp = groupServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Group> getAllgroups()
    {
        return groupServiceImp.getAllGroups();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Group getGroupById(@PathVariable("id") Long id)
    {
        return groupServiceImp.getGroupById(id);
    }

    @PostMapping
    @ResponseBody
    public Group addGroup(@RequestBody Group group)
    {
        return groupServiceImp.addGroup(group);
    }


    @PutMapping
    @ResponseBody
    public Group updateGroup(@RequestBody Group group)
    {
        return groupServiceImp.updateGroup(group);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteGroup(@PathVariable("id") Long id)
    {
        groupServiceImp.deleteGroup(id);
        return ("deleted successfully");
    }
}
