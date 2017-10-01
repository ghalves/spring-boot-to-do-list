package com.todo.controller;

import com.todo.entity.Task;
import com.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") int id) {
        return taskService.getTaskById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Task deleteTaskById(@PathVariable("id") int id) {
        return taskService.deleteTaskById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateTask(@RequestBody Task task) {
        taskService.updateTaskById(task);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertTask(@RequestBody Task task) {
        taskService.insertTask(task);
    }
}
