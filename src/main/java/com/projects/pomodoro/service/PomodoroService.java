package com.projects.pomodoro.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projects.pomodoro.model.PomodoroSession;
import com.projects.pomodoro.model.Todo;
import com.projects.pomodoro.repository.PomodoroSessionRepository;
import com.projects.pomodoro.repository.TodoRepository;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class PomodoroService {
  private final PomodoroSessionRepository sessionRepository;
  private final TodoRepository todoRepository;

  @Autowired
  public PomodoroService(PomodoroSessionRepository sessionRepository, TodoRepository todoRepository) {
    this.sessionRepository = sessionRepository;
    this.todoRepository = todoRepository;
  }

  @Transactional
  public PomodoroSession startSession(Long todoId, boolean isBreak) {
    Todo todo = todoRepository.findById(todoId)
        .orElseThrow(() -> new EntityNotFoundException("Todo not found"));

    PomodoroSession session = new PomodoroSession();
    session.setTodo(todo);
    session.setStartTime(LocalDateTime.now());
    session.setEndTime(null);
    session.setDuration(isBreak ? 5 * 60 : 25 * 60); // 5 min for break, 25 min for work
    session.setRemainingTime(session.getDuration());
    session.setIsBreak(isBreak);
    return sessionRepository.save(session);
  }

  @Transactional
  public PomodoroSession endSession(Long sessionId) {
    PomodoroSession session = sessionRepository.findById(sessionId)
        .orElseThrow(() -> new EntityNotFoundException("Session not found"));

    session.setEndTime(LocalDateTime.now());
    session.setRemainingTime(0);

    if (!session.getIsBreak()) {
      Todo todo = session.getTodo();
      long elapsedSeconds = ChronoUnit.SECONDS.between(session.getStartTime(), session.getEndTime());
      todo.setAccumulatedTime(todo.getAccumulatedTime() + (int) elapsedSeconds);
      todoRepository.save(todo);
    }

    return sessionRepository.save(session);
  }

  public PomodoroSession getSession(Long sessionId) {
    return sessionRepository.findById(sessionId)
        .orElseThrow(() -> new EntityNotFoundException("Session not found"));
  }

  @Transactional
  public PomodoroSession updateRemainingTime(Long sessionId) {
    PomodoroSession session = getSession(sessionId);

    long elapsedTime = ChronoUnit.SECONDS.between(session.getStartTime(), LocalDateTime.now());
    int newRemainingTime = session.getDuration() - (int) elapsedTime;

    if (newRemainingTime < 0) {
      newRemainingTime = 0;
    }

    session.setRemainingTime(newRemainingTime);
    return sessionRepository.save(session);
  }
}
