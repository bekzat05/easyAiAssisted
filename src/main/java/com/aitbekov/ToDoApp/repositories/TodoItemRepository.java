package com.aitbekov.ToDoApp.repositories;

import com.aitbekov.ToDoApp.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
