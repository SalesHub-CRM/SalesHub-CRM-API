package com.example.CRM.services;

import com.example.CRM.entities.Group;

import java.util.List;

public interface GroupService {
    public Group addGroup(Group group);
    public Group updateGroup(Group group);
    public Group getGroupById(Long id);
    public List<Group> getAllGroups();
    public void deleteGroup(Long id);

}
