package io.tasklist.repository.sql;

import org.junit.jupiter.api.BeforeEach;

import io.tasklist.repository.ToDoRepository;
import io.tasklist.service.ToDoService;

import static org.mockito.Mockito.*;

public class ToDoListRepositoryTest {
	private ToDoRepository repository;
	private ToDoService service;
	
	@BeforeEach
	void setUp() {
		repository = mock(ToDoRepository.class);
		service = new ToDoService(repository);
		service.addTask(null);
		
	}
	

}
