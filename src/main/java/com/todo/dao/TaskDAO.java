package com.todo.dao;

import com.todo.entity.Task;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TaskDAO implements DAOBase<Task> {

    private static Map<Integer, Task> tasks;
    private Task task;

    static {
        tasks = new HashMap<Integer, Task>() {
            {
                put(1, new Task(1, "Supermarket", "Buy potatoes", LocalDateTime.now().toString()));
                put(2, new Task(2, "Lunch", "Fish with potatoes", LocalDateTime.now().toString()));
                put(3, new Task(3, "Programming", "Find Javascript issue", LocalDateTime.now().toString()));

            }
        };
    }

    @Override
    public void create(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void update(Task task) {
        this.task = tasks.get(task.getId());
        this.task.setName(task.getName());
        this.task.setDescription(task.getDescription());
        this.task.setDate(LocalDateTime.now().toString());
    }

    @Override
    public Task delete(int id) {
        return tasks.remove(id);
    }

    @Override
    public Task findById(int id) {
        return tasks.get(id);
    }

    @Override
    public Collection<Task> list() {
        return this.tasks.values();
    }
}
