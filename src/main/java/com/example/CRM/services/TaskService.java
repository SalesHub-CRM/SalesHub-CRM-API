package com.example.CRM.services;

import com.example.CRM.entities.Task;

import java.util.List;

public interface TaskService {
    public Task addTask(Task task);
    public Task updateTask(Task task);
    public Task getTaskById(Long id);
    public List<Task> getAllTasks();
    public void deleteTask(Long id);
}
