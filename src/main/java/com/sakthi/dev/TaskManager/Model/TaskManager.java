package com.sakthi.dev.TaskManager.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class TaskManager {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String description;
    boolean isCompleted;
    Long userId;
}
