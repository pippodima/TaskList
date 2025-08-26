package io.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TodoListTest {
	
    private ToDoList todolist;

    private static final String TASK_TEST = "test";

    @BeforeEach
    void setUp() {
        todolist = new ToDoList();
    }

    @Test
    void newTodoListShouldBeEmpty() {
        assertTrue(todolist.getAllTasks().isEmpty());
    }

    @Test
    void addTaskShouldStoreTask() {
        todolist.addToDo(TASK_TEST);
        assertTrue(
            todolist.getAllTasks()
                    .stream()
                    .anyMatch(todo -> todo.getTitle().equals(TASK_TEST))
        );
    }
    
    @Test
    void newTaskShouldNotBeMarkedAsDone() {
        todolist.addToDo(TASK_TEST);

        ToDo task = todolist.getTask(TASK_TEST);

        assertFalse(task.isDone(), "A new task should not be marked as done");
    }


    @Test
    void deletingTaskShouldRemoveTaskFromList() {
        todolist.addToDo(TASK_TEST);
        todolist.removeToDo(TASK_TEST);
        assertFalse(
            todolist.getAllTasks()
                    .stream()
                    .anyMatch(todo -> todo.getTitle().equals(TASK_TEST))
        );
    }
    

    @Test
    void searchTaskByEmptyNameShouldThrow() {
        assertThrows(IllegalArgumentException.class, 
            () -> todolist.getTask(""));
    }

	
    @Test
    void searchTaskByNameShouldReturnTask() {
        todolist.addToDo(TASK_TEST);

        ToDo found = todolist.getTask(TASK_TEST);

        assertNotNull(found);
        assertEquals(TASK_TEST, found.getTitle());
    }

	@Test
	void markTaskAsDoneShouldChangeState() {
		todolist.addToDo(TASK_TEST);
		ToDo todo = todolist.getTask(TASK_TEST);
	    assertFalse(todo.isDone(), "Task should not be done initially");
		todo.markAsDone();
	    assertTrue(todo.isDone(), "Task should be marked as done");
	}
    
}

