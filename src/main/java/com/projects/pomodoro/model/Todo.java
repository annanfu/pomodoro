package com.projects.pomodoro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  private Long id;
  private String title;
  private int accumulatedTime = 0;

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
