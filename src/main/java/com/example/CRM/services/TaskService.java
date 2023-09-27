package com.example.CRM.services;

import com.example.CRM.dto.request.TaskRequest;
import com.example.CRM.dto.response.TaskResponse;
import com.example.CRM.entities.Task;

import java.util.List;

public interface TaskService {
    public Task addTask(TaskRequest task);
    public Task updateTask(TaskRequest task,Long id);
    public TaskResponse getTaskById(Long id);
    public List<TaskResponse> getAllTasks();
    public void deleteTask(Long id);
    public List<TaskResponse>listByEmployeeId(Long employeeId);
    public List<TaskResponse>listByGroup(Long groupId);
    public List<TaskResponse>listByAdminId(Long adminId);
    public List<TaskResponse>listByAssignedTo(Long assignedTo);
}
