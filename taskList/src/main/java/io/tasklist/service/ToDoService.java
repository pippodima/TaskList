package io.tasklist.service;

import java.util.List;

import io.tasklist.model.ToDo;
import io.tasklist.repository.ToDoRepository;

public class ToDoService {
    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public void addTask(String title) {
        repository.save(new ToDo(title));
    }

    public void removeTask(String title) {
        repository.deleteByTitle(title);
    }

    public List<ToDo> listTasks() {
        return repository.findAll();
    }

    public ToDo findTask(String title) {
        return repository.findByTitle(title)
                         .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }
}
