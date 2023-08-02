package com.example.CRM.services;

import com.example.CRM.dto.request.GroupRequest;
import com.example.CRM.entities.Group;

import java.util.List;

public interface GroupService {
    public Group addGroup(GroupRequest group);
    public Group updateGroup(GroupRequest group,Long id);
    public Group getGroupById(Long id);
    public List<Group> getAllGroups();
    public void deleteGroup(Long id);

}
