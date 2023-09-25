package com.example.CRM.services;

import com.example.CRM.components.UserServiceComponent;
import com.example.CRM.dto.mapper.TaskMapper;
import com.example.CRM.dto.request.TaskRequest;
import com.example.CRM.dto.response.TaskResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Group;
import com.example.CRM.entities.Task;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService{
    private final TaskRepository taskRepository;
    private final GroupRepository groupRepository;
    private final UserServiceComponent userServiceComponent;
    @Autowired
    public TaskServiceImp(TaskRepository taskRepository,GroupRepository groupRepository,UserServiceComponent userServiceComponent)
    {
        this.taskRepository=taskRepository;
        this.groupRepository=groupRepository;
        this.userServiceComponent=userServiceComponent;
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
    public TaskResponse getTaskById(Long id) {
        Task tsk = taskRepository.findById(id).orElse(null);
        UserResponseDTO creator = userServiceComponent.fetchUserById(tsk.getEmployeeId());
        UserResponseDTO assignedTo = userServiceComponent.fetchUserById(tsk.getAssignedto());

        TaskMapper taskMapper = new TaskMapper();

        return taskMapper.convertToDTO(tsk,creator,assignedTo);
    }

    @Override
    public List<TaskResponse> getAllTasks() {

        List<Task>allTasks = taskRepository.findAll();

        List<TaskResponse>taskResponses=new ArrayList<>();

        TaskMapper taskMapper = new TaskMapper();

        for(Task task : allTasks)
        {
            UserResponseDTO creator = userServiceComponent.fetchUserById(task.getEmployeeId());
            UserResponseDTO assignedTo = userServiceComponent.fetchUserById(task.getAssignedto());
            TaskResponse taskResponse = taskMapper.convertToDTO(task,creator,assignedTo);
            taskResponses.add(taskResponse);
        }

        return taskResponses;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskResponse>listByEmployeeId(Long employeeId)
    {
        List<Task>allTasks = taskRepository.findByEmployeeId(employeeId);
        List<TaskResponse>taskResponses=new ArrayList<>();

        TaskMapper taskMapper = new TaskMapper();

        for(Task task : allTasks)
        {
            UserResponseDTO creator = userServiceComponent.fetchUserById(task.getEmployeeId());
            UserResponseDTO assignedTo = userServiceComponent.fetchUserById(task.getAssignedto());
            TaskResponse taskResponse = taskMapper.convertToDTO(task,creator,assignedTo);
            taskResponses.add(taskResponse);
        }

        return taskResponses;
    }

    @Override
    public List<TaskResponse> listByGroup(Long groupId) {

        List<Task>allTasks = taskRepository.findByGroupId(groupId);
        List<TaskResponse>taskResponses=new ArrayList<>();

        TaskMapper taskMapper = new TaskMapper();

        for(Task task : allTasks)
        {
            UserResponseDTO creator = userServiceComponent.fetchUserById(task.getEmployeeId());
            UserResponseDTO assignedTo = userServiceComponent.fetchUserById(task.getAssignedto());
            TaskResponse taskResponse = taskMapper.convertToDTO(task,creator,assignedTo);
            taskResponses.add(taskResponse);
        }

        return taskResponses;
    }
}
