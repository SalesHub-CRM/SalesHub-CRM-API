package com.example.CRM.controllers;

import com.example.CRM.dto.request.TaskRequest;
import com.example.CRM.dto.response.TaskResponse;
import com.example.CRM.entities.Task;
import com.example.CRM.services.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskServiceImp taskServiceImp;
    @Autowired

    public TaskController(TaskServiceImp taskServiceImp) {
        this.taskServiceImp = taskServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<TaskResponse> getAllTasks()
    {
        return taskServiceImp.getAllTasks();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TaskResponse getTaskById(@PathVariable("id") Long id)
    {
        return taskServiceImp.getTaskById(id);
    }

    @PostMapping
    @ResponseBody
    public Task addTask(@RequestBody TaskRequest task)
    {
        return taskServiceImp.addTask(task);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Task updateTask(@RequestBody TaskRequest task,@PathVariable("id") Long id)
    {
        return taskServiceImp.updateTask(task,id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteTask(@PathVariable("id") Long id)
    {
        taskServiceImp.deleteTask(id);
        return ("deleted successfully");
    }

    @GetMapping("/byEmployee/{id}")
    @ResponseBody
    public List<TaskResponse> listByEmployeeId(@PathVariable("id") Long id)
    {
        return taskServiceImp.listByEmployeeId(id);
    }

    @GetMapping("/byGroup/{id}")
    @ResponseBody
    public List<TaskResponse> listByGroup(@PathVariable("id") Long id)
    {
        return taskServiceImp.listByGroup(id);
    }

    @GetMapping("/byAdminId/{id}")
    @ResponseBody
    public List<TaskResponse>listByAdmin(@PathVariable("id") Long id)
    {
        return taskServiceImp.listByAdminId(id);
    }

    @GetMapping("/byAssigned/{id}")
    @ResponseBody
    public List<TaskResponse>listByAssigned(@PathVariable("id") Long id)
    {
        return taskServiceImp.listByAssignedTo(id);
    }
}
