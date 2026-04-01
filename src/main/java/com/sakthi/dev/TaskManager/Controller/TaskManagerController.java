package com.sakthi.dev.TaskManager.Controller;

import com.sakthi.dev.TaskManager.Model.TaskManager;
import com.sakthi.dev.TaskManager.Services.TaskManagerServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Getter
@Setter
@RestController

public class TaskManagerController {
    @Autowired
    TaskManagerServices taskmanagerServices;
    private Long getCurrentUserId() {
        UsernamePasswordAuthenticationToken auth =
                (UsernamePasswordAuthenticationToken)
                        SecurityContextHolder.getContext().getAuthentication();
        return (Long) auth.getDetails();
    }

    @PostMapping("/create")
    ResponseEntity<TaskManager> Create(@RequestBody TaskManager taskManager)
    {
        System.out.println(getCurrentUserId());
        taskManager.setUserId(getCurrentUserId());
        return new ResponseEntity<>(taskmanagerServices.create(taskManager),HttpStatus.CREATED);
    }
    @PutMapping("/Update")
    ResponseEntity<?> Update(@RequestBody TaskManager taskManager)
    {
        Long TaskId =taskManager.getId();
        TaskManager TaskDetail=taskmanagerServices.findId(TaskId);

        if(getCurrentUserId() != TaskDetail.getUserId())
        {
            return new ResponseEntity<>("Invalid Access", HttpStatus.UNAUTHORIZED);
        }
        taskManager.setUserId(getCurrentUserId());
        return new ResponseEntity<>(taskmanagerServices.update(taskManager),HttpStatus.OK);
    }
    @GetMapping("/my-tasks")
    ResponseEntity<List<TaskManager>> GetMyTasks() {
        Long userId = getCurrentUserId();
        return new ResponseEntity<>(taskmanagerServices.GetTasks(userId), HttpStatus.OK);
    }
    @DeleteMapping("/deleteMyTask")
    ResponseEntity<String> Delete(@RequestBody TaskManager taskManager)
    {
        Long TaskId =taskManager.getId();
        TaskManager TaskDetail=taskmanagerServices.findId(TaskId);

        if(getCurrentUserId() != TaskDetail.getUserId())
        {
            return new ResponseEntity<>("Invalid Access", HttpStatus.UNAUTHORIZED);
        }
        return taskmanagerServices.DeleteTask(taskManager);
    }


}
