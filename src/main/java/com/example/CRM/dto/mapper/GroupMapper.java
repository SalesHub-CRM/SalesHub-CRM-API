package com.example.CRM.dto.mapper;

import com.example.CRM.dto.response.GroupResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Group;

import java.util.List;

public class GroupMapper {
    public GroupResponse convertToDTO(Group group, UserResponseDTO admin, List<UserResponseDTO>employees)
    {
        GroupResponse groupResponse = new GroupResponse();

        groupResponse.setId(group.getId());
        groupResponse.setName(group.getName());
        groupResponse.setCreatedat(group.getCreatedat());
        groupResponse.setUpdatedat(group.getUpdatedat());
        groupResponse.setAdmin(admin);
        groupResponse.setEmployees(employees);

        return groupResponse;
    }
}
