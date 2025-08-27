package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import io.tasklist.model.ToDo;
import io.tasklist.repository.ToDoRepository;
import io.tasklist.service.ToDoService;

public class ToDoServiceTest {
	
    private static final String TASK_TEST = "test";

	
	@Test
	void shouldReturnTitleWhenTaskExist() {
		ToDoRepository mockRepo = mock(ToDoRepository.class);
		
		when(mockRepo.findByTitle(TASK_TEST)).thenReturn(Optional.of(new ToDo(TASK_TEST)));
		
		ToDoService service = new ToDoService(mockRepo);
		String result = service.findTask(TASK_TEST).getTitle();
		assertEquals(TASK_TEST, result);
		
	}

}
