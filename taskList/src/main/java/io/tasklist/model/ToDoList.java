package io.tasklist.model;

import java.util.ArrayList;
import java.util.List;


public class ToDoList 
{
	private final List<ToDo> tasks = new ArrayList<>();

	public void addToDo(String todoTitle) {
		ToDo todo = new ToDo(todoTitle);
        tasks.add(todo);
    }


    public List<ToDo> getAllTasks() {
        return new ArrayList<>(tasks);  
    }

	public void removeToDo(String todoTitle) {
	    tasks.removeIf(todo -> todo.getTitle().equals(todoTitle));
	}

	public ToDo getTask(String title) {
	    if (title == null || title.isBlank()) {
	        throw new IllegalArgumentException("Task title cannot be empty");
	    }
	    return tasks.stream()
	                .filter(todo -> todo.getTitle().equals(title))
	                .findFirst()
	                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + title));
	}


}
