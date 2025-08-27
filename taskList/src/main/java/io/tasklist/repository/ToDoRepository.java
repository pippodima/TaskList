package io.tasklist.repository;

import java.util.List;
import java.util.Optional;

import io.tasklist.model.ToDo;

public interface ToDoRepository {
    void save(ToDo todo);
    Optional<ToDo> findByTitle(String title);
    List<ToDo> findAll();
    void deleteByTitle(String title);
}
