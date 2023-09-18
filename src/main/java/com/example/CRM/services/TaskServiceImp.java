package com.example.CRM.services;

import com.example.CRM.dto.request.TaskRequest;
import com.example.CRM.entities.Group;
import com.example.CRM.entities.Task;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{
    private final TaskRepository taskRepository;
    private final GroupRepository groupRepository;
    @Autowired
    public TaskServiceImp(TaskRepository taskRepository,GroupRepository groupRepository)
    {
        this.taskRepository=taskRepository;
        this.groupRepository=groupRepository;
    }

    @Override
    public Task addTask(TaskRequest task) {
        Group group=groupRepository.findById(task.getGroupId()).orElse(null);
        Task tsk=new Task();
        tsk.setSubject(task.getSubject());
        tsk.setComment(task.getComment());
        tsk.setAssignedto(task.getAssignedto());
        tsk.setDuedate(task.getDuedate());
        tsk.setStatus(task.getStatus());
        tsk.setPriority(task.getPriority());
        tsk.setEmployeeId(task.getEmployeeId());
        tsk.setGroup(group);

        return taskRepository.save(tsk);
    }

    @Override
    public Task updateTask(TaskRequest task,Long id) {
        Group group=groupRepository.findById(task.getGroupId()).orElse(null);
        Task tsk=taskRepository.findById(id).orElse(null);
        tsk.setSubject(task.getSubject());
        tsk.setComment(task.getComment());
        tsk.setAssignedto(task.getAssignedto());
        tsk.setDuedate(task.getDuedate());
        tsk.setStatus(task.getStatus());
        tsk.setPriority(task.getPriority());
        tsk.setEmployeeId(task.getEmployeeId());
        tsk.setGroup(group);
        return taskRepository.save(tsk);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task>listByEmployeeId(Long employeeId)
    {
        return taskRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Task> listByGroup(Long groupId) {
        return taskRepository.findByGroupId(groupId);
    }
}
