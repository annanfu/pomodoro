package com.projects.pomodoro.controller;

import com.projects.pomodoro.model.PomodoroSession;
import com.projects.pomodoro.service.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
@CrossOrigin
public class PomodoroSessionController {
  @Autowired
  private PomodoroService pomodoroService;

  @PostMapping("/{todoId}/start")
  public PomodoroSession startSession(@PathVariable Long todoId) {
    return pomodoroService.startSession(todoId);
  }

  @PostMapping("/{sessionId}/end")
  public PomodoroSession endSession(@PathVariable Long sessionId) {
    return pomodoroService.endSession(sessionId);
  }

  @GetMapping("/{sessionId}")
  public PomodoroSession getSession(@PathVariable Long sessionId) {
    return pomodoroService.getSession(sessionId);
  }

  @PatchMapping("/{sessionId}/update")
  public PomodoroSession updateRemainingTime(@PathVariable Long sessionId) {
    return pomodoroService.updateRemainingTime(sessionId);
  }
}
