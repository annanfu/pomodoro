package com.projects.pomodoro.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Todo {
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  private Long id;
  private String title;
  private int accumulatedTime;

  @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PomodoroSession> pomodoroSessions;
  public Todo() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getAccumulatedTime() {
    return accumulatedTime;
  }

  public void setAccumulatedTime(int accumulatedTime) {
    this.accumulatedTime = accumulatedTime;
  }

}
