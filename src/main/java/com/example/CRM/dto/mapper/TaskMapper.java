package com.example.CRM.dto.mapper;

import com.example.CRM.dto.response.TaskResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Task;

public class TaskMapper {
    public TaskResponse convertToDTO(Task task, UserResponseDTO creator, UserResponseDTO assignedTo)
    {
        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setId(task.getId());
        taskResponse.setSubject(task.getSubject());
        taskResponse.setComment(task.getComment());
        taskResponse.setAssignedto(assignedTo);
        taskResponse.setDuedate(task.getDuedate());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setPriority(task.getPriority());
        taskResponse.setEmployee(creator);
        taskResponse.setCreatedat(task.getCreatedat());
        taskResponse.setUpdatedat(task.getUpdatedat());

        return taskResponse;
    }
}
