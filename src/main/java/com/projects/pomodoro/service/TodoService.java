package com.projects.pomodoro.service;

import com.projects.pomodoro.model.Todo;

import java.util.List;

public interface TodoService {
  public Todo saveTodo(Todo todo);
  public List<Todo> getAllTodos();
  public void deleteTodoById(Long id);

}
