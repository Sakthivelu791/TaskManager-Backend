package com.sakthi.dev.TaskManager.Services;

import com.sakthi.dev.TaskManager.Model.TaskManager;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import com.sakthi.dev.TaskManager.Repository.TaskManagerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Service
public class TaskManagerServices {
    @Autowired
    TaskManagerRepository taskManagerRepositoryRepository;

    public TaskManager create(TaskManager taskManager)
    {
        return taskManagerRepositoryRepository.save(taskManager);
    }
    public TaskManager update(TaskManager taskManager)
    {
        return taskManagerRepositoryRepository.save(taskManager);
    }
    public TaskManager GetById(Long id)
    {
        return taskManagerRepositoryRepository.findById(id).orElseThrow(()->new RuntimeException("Task Not Found"));
    }
    public List<TaskManager> GetTasks(Long userId) {
        return taskManagerRepositoryRepository.findAllByuserId(userId);
    }
    public ResponseEntity<String> DeleteTask(TaskManager rentalHouse){
        taskManagerRepositoryRepository.delete(GetById(rentalHouse.getId()));
        return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
    }
    public TaskManager findId(Long HouseId)
    {
        return taskManagerRepositoryRepository.findById(HouseId).orElseThrow(()->new RuntimeException("Task Not Found"));
    }
}
