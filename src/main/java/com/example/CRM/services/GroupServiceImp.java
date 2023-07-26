package com.example.CRM.services;

import com.example.CRM.entities.Group;
import com.example.CRM.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImp implements GroupService{
    private final GroupRepository groupRepository;
    @Autowired
    public GroupServiceImp(GroupRepository groupRepository)
    {
        this.groupRepository=groupRepository;
    }

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
