package com.example.CRM.services;

import com.example.CRM.dto.request.GroupRequest;
import com.example.CRM.dto.response.GroupResponse;
import com.example.CRM.entities.Group;

import java.util.List;

public interface GroupService {
    public Group addGroup(GroupRequest group);
    public Group updateGroup(GroupRequest group,Long id);
    public GroupResponse getGroupById(Long id);
    public List<GroupResponse> getAllGroupsByAdmin(Long adminId);
    public void deleteGroup(Long id);
    public int getGroupCountByAdmin(Long adminId);

}
