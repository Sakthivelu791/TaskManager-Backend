package com.sakthi.dev.TaskManager.Repository;

import com.sakthi.dev.TaskManager.Model.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskManagerRepository extends JpaRepository<TaskManager,Long> {

    List<TaskManager> findAllByuserId(Long userId);
}
