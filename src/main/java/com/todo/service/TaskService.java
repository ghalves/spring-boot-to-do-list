package com.todo.service;

import com.todo.dao.TaskDAO;
import com.todo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    public void insertTask(Task task) {
        taskDAO.create(task);
    }

    public void updateTaskById(Task task) {
        taskDAO.update(task);
    }

    public Task deleteTaskById(int id) {
        return taskDAO.delete(id);
    }

    public Task getTaskById(int id) {
        return taskDAO.findById(id);
    }

    public Collection<Task> getAllTasks() {
        return taskDAO.list();
    }
}
