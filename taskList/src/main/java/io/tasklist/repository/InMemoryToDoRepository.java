package io.tasklist.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.tasklist.model.ToDo;

public class InMemoryToDoRepository implements ToDoRepository{
	private final List<ToDo> tasks = new ArrayList<>();
	
	@Override
	public void save(ToDo todo) {
		tasks.add(todo);
		
	}

	@Override
	public Optional<ToDo> findByTitle(String title) {
		return tasks.stream()
                .filter(t -> t.getTitle().equals(title))
                .findFirst();
	}

	@Override
	public List<ToDo> findAll() {
		return new ArrayList<>(tasks);
	}

	@Override
	public void deleteByTitle(String title) {
        tasks.removeIf(t -> t.getTitle().equals(title));
		
	}
	
}
