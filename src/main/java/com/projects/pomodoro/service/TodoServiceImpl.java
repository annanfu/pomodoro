package com.projects.pomodoro.service;

import com.projects.pomodoro.model.Todo;
import com.projects.pomodoro.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
  @Transactional
  public void deleteTodoById(Long id) {
    if (!todoRepository.existsById(id)) {
      throw new EntityNotFoundException("Todo not found with id " + id);
    }
    todoRepository.deleteById(id); // This will trigger cascading deletes for related PomodoroSession entities
  }

  @Override
  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }
}
