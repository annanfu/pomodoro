package com.projects.pomodoro.controller;

import com.projects.pomodoro.model.PomodoroSession;
import com.projects.pomodoro.service.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*")
public class PomodoroSessionController {
  @Autowired
  private PomodoroService pomodoroService;

  @PostMapping("/{todoId}/start")
  public PomodoroSession startSession(@PathVariable Long todoId, @RequestParam boolean isBreak) {
    return pomodoroService.startSession(todoId, isBreak);
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
