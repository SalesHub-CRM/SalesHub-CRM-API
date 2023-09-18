package com.example.CRM.services;

import com.example.CRM.dto.request.TaskRequest;
import com.example.CRM.entities.Task;

import java.util.List;

public interface TaskService {
    public Task addTask(TaskRequest task);
    public Task updateTask(TaskRequest task,Long id);
    public Task getTaskById(Long id);
    public List<Task> getAllTasks();
    public void deleteTask(Long id);
    public List<Task>listByEmployeeId(Long employeeId);
    public List<Task>listByGroup(Long groupId);
}
