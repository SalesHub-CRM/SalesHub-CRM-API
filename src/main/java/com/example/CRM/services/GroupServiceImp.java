package com.example.CRM.services;

import com.example.CRM.dto.request.GroupRequest;
import com.example.CRM.entities.Administrator;
import com.example.CRM.entities.Group;
import com.example.CRM.entities.User;
import com.example.CRM.repositories.AdministratorRepository;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImp implements GroupService{
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final AdministratorRepository administratorRepository;
    @Autowired
    public GroupServiceImp(GroupRepository groupRepository,UserRepository userRepository,AdministratorRepository administratorRepository)
    {
        this.groupRepository=groupRepository;
        this.userRepository=userRepository;
        this.administratorRepository=administratorRepository;
    }

    @Override
    public Group addGroup(GroupRequest group) {

        /*System.out.println("start here");
        System.out.println(group.getAdminId());*/

        Administrator administrator = administratorRepository.findById(group.getAdminId()).orElse(null);
        /*System.out.println("admin here");
        System.out.println(administrator.getEmail());*/
        Group grp = new Group();
        grp.setName(group.getName());
        groupRepository.save(grp);
        grp.setAdministrator(administrator);
        return groupRepository.save(grp);
    }

    @Override
    public Group updateGroup(GroupRequest group,Long id) {
        /*System.out.println("error starts here");
        System.out.println(group.getAdminId());*/
        Administrator administrator = administratorRepository.findById(group.getAdminId()).orElse(null);

        /*System.out.println("admin starts here");
        System.out.println(administrator.getEmail());*/

        Group grp = groupRepository.findById(id).orElse(null);

        /*System.out.println("group starts here");
        System.out.println(grp.getName());*/

        grp.setName(group.getName());

        /*System.out.println(" modified group starts here");
        System.out.println(grp.getName());*/
        grp.setAdministrator(administrator);

        return groupRepository.save(grp);
    }

    @Override
    public Group getGroupById(Long id) {
        System.out.println(groupRepository.findById(id).orElse(null).getAdministrator());
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
