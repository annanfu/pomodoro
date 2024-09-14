package com.projects.pomodoro.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PomodoroSession {
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  private Long id;

  @ManyToOne
  private Todo todo;

  private int duration;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private int remainingTime;
  private boolean isBreak;

  public PomodoroSession() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Todo getTodo() {
    return todo;
  }

  public void setTodo(Todo todo) {
    this.todo = todo;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }


  public int getRemainingTime() {
    return remainingTime;
  }

  public void setRemainingTime(int remainingTime) {
    this.remainingTime = remainingTime;
  }

  public boolean getIsBreak() {
    return isBreak;
  }

  public void setIsBreak(boolean isBreak) {
    this.isBreak = isBreak;
  }
}
