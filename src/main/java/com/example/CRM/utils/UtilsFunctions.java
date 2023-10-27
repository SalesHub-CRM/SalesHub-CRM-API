package com.example.CRM.utils;

import com.example.CRM.entities.Client;
import com.example.CRM.entities.Group;
import com.example.CRM.repositories.ClientRepository;
import com.example.CRM.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtilsFunctions {
     private GroupRepository groupRepository;
     private ClientRepository clientRepository;

    public UtilsFunctions(GroupRepository groupRepository, ClientRepository clientRepository) {
        this.groupRepository = groupRepository;
        this.clientRepository = clientRepository;
    }

    public Date getFirstDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }
    public List<Long> getGroupIdsByAdminId(Long adminId) {
        List<Group> groups = groupRepository.findByAdminId(adminId);
        return groups.stream().map(Group::getId).collect(Collectors.toList());
    }

    public List<Client> getClientListByAdminId(Long adminId) {
        List<Long> groupIds = getGroupIdsByAdminId(adminId);
        return clientRepository.findByGroup_IdIn(groupIds);
    }
}
