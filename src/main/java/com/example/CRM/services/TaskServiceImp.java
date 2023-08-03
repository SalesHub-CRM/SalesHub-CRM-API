package com.example.CRM.services;

import com.example.CRM.dto.request.TaskRequest;
import com.example.CRM.entities.Employee;
import com.example.CRM.entities.Group;
import com.example.CRM.entities.Task;
import com.example.CRM.repositories.EmployeeRepository;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{
    private final TaskRepository taskRepository;
    private final GroupRepository groupRepository;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public TaskServiceImp(TaskRepository taskRepository,GroupRepository groupRepository,EmployeeRepository employeeRepository)
    {
        this.taskRepository=taskRepository;
        this.groupRepository=groupRepository;
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Task addTask(TaskRequest task) {
        Group group=groupRepository.findById(task.getGroupId()).orElse(null);
        Employee employee=employeeRepository.findById(task.getEmployeeId()).orElse(null);
        Task tsk=new Task();
        tsk.setSubject(task.getSubject());
        tsk.setComment(task.getComment());
        tsk.setAssignedto(task.getAssignedto());
        tsk.setDuedate(task.getDuedate());
        tsk.setStatus(task.getStatus());
        tsk.setPriority(task.getPriority());
        taskRepository.save(tsk);
        tsk.setGroup(group);
        tsk.setEmployee(employee);

        return taskRepository.save(tsk);
    }

    @Override
    public Task updateTask(TaskRequest task,Long id) {
        Group group=groupRepository.findById(task.getGroupId()).orElse(null);
        Employee employee=employeeRepository.findById(task.getEmployeeId()).orElse(null);
        Task tsk=taskRepository.findById(id).orElse(null);
        tsk.setSubject(task.getSubject());
        tsk.setComment(task.getComment());
        tsk.setAssignedto(task.getAssignedto());
        tsk.setDuedate(task.getDuedate());
        tsk.setStatus(task.getStatus());
        tsk.setPriority(task.getPriority());
        tsk.setGroup(group);
        tsk.setEmployee(employee);
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
}
