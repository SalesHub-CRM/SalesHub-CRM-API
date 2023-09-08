package com.example.CRM.services;

import com.example.CRM.components.UserServiceComponent;
import com.example.CRM.dto.mapper.GroupMapper;
import com.example.CRM.dto.request.GroupRequest;
import com.example.CRM.dto.response.GroupResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Group;
import com.example.CRM.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImp implements GroupService{
    private final GroupRepository groupRepository;
    private final UserServiceComponent userServiceComponent;
    @Autowired
    public GroupServiceImp(GroupRepository groupRepository, UserServiceComponent userServiceComponent)
    {
        this.groupRepository=groupRepository;
        this.userServiceComponent=userServiceComponent;
    }

    @Override
    public Group addGroup(GroupRequest group) {

        Group grp = new Group();
        grp.setName(group.getName());
        grp.setAdminId(group.getAdminId());
        return groupRepository.save(grp);
    }

    @Override
    public Group updateGroup(GroupRequest group,Long id) {

        Group grp = groupRepository.findById(id).orElse(null);
        grp.setName(group.getName());

        return groupRepository.save(grp);
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        Group group = groupRepository.findById(id).orElse(null);
        UserResponseDTO admin = userServiceComponent.fetchUserById(group.getAdminId());
        List<UserResponseDTO>employees = userServiceComponent.listUsersByGroupId(id);
        GroupMapper groupMapper = new GroupMapper();
        return groupMapper.convertToDTO(group,admin,employees);
    }

    @Override
    public List<GroupResponse> getAllGroupsByAdmin(Long adminId) {
        UserResponseDTO admin = userServiceComponent.fetchUserById(adminId);
        System.out.println("admin");
        System.out.println(admin);
        List<Group>groups = groupRepository.findByAdminId(adminId);
        System.out.println("groups");
        System.out.println(groups);
        List<GroupResponse>groupResponses=new ArrayList<>();
        GroupMapper groupMapper = new GroupMapper();

        for (Group group : groups)
        {
            List<UserResponseDTO>employees = userServiceComponent.listUsersByGroupId(group.getId());
            GroupResponse groupResponse = groupMapper.convertToDTO(group,admin,employees);
            groupResponses.add(groupResponse);
        }

        return groupResponses;
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
