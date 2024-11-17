package com.aitbekov.ToDoApp.service;


import com.aitbekov.ToDoApp.models.TodoItem;
import com.aitbekov.ToDoApp.repositories.TodoItemRepository;
import com.aitbekov.ToDoApp.services.TodoItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoItemServiceTest {

    private final TodoItemRepository todoItemRepository = mock(TodoItemRepository.class);
    private final TodoItemService todoItemService = new TodoItemService(todoItemRepository);

    @Test
    void testGetTodoItemById() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1L);
        todoItem.setTitle("Sample");

        when(todoItemRepository.findById(1L)).thenReturn(Optional.of(todoItem));

        Optional<TodoItem> result = todoItemService.getTodoItemById(1L);
        assertTrue(result.isPresent());
        assertEquals("Sample", result.get().getTitle());
    }
}
