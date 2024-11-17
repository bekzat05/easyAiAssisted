package com.aitbekov.ToDoApp.services;

import com.aitbekov.ToDoApp.models.TodoItem;
import com.aitbekov.ToDoApp.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getTodoItemById(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public TodoItem updateTodoItem(Long id, TodoItem todoItemDetails) {
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoItem not found"));
        todoItem.setTitle(todoItemDetails.getTitle());
        todoItem.setDescription(todoItemDetails.getDescription());
        return todoItemRepository.save(todoItem);
    }

    public void deleteTodoItem(Long id) {
        todoItemRepository.deleteById(id);
    }
}
