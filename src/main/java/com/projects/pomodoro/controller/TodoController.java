package com.projects.pomodoro.controller;

import com.projects.pomodoro.model.Todo;
import com.projects.pomodoro.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
// Allow requests from any origin to access the resource
@CrossOrigin(origins = "*")


public class TodoController {
  @Autowired
  private TodoService todoService;

  @PostMapping("/add")
  public String add(@RequestBody Todo todo) {
    todoService.saveTodo(todo);
    return "Todo added successfully";
  }

  @DeleteMapping("/delete/{todoId}")
  public String delete(@PathVariable Long todoId) {
    todoService.deleteTodoById(todoId);
    return "Todo deleted successfully";
  }

  @GetMapping("/getAll")
  public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
  }
}
