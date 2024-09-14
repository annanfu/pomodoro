package com.projects.pomodoro.service;

import com.projects.pomodoro.model.Todo;
import com.projects.pomodoro.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

  // inject TodoRepository into TodoServiceImpl
  @Autowired
  private TodoRepository todoRepository;

  @Override
  public Todo saveTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public void deleteTodoById(Long id) {
    todoRepository.deleteById(id);
  }

  @Override
  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }
}
