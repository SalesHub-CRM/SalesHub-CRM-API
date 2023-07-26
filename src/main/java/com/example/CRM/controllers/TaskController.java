package com.example.CRM.controllers;

import com.example.CRM.entities.Task;
import com.example.CRM.services.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {
    private final TaskServiceImp taskServiceImp;
    @Autowired

    public TaskController(TaskServiceImp taskServiceImp) {
        this.taskServiceImp = taskServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Task> getAllTasks()
    {
        return taskServiceImp.getAllTasks();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Task getTaskById(@PathVariable("id") Long id)
    {
        return taskServiceImp.getTaskById(id);
    }

    @PostMapping
    @ResponseBody
    public Task addTask(@RequestBody Task task)
    {
        return taskServiceImp.addTask(task);
    }


    @PutMapping
    @ResponseBody
    public Task updateTask(@RequestBody Task task)
    {
        return taskServiceImp.updateTask(task);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteTask(@PathVariable("id") Long id)
    {
        taskServiceImp.deleteTask(id);
        return ("deleted successfully");
    }
}
