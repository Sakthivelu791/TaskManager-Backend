package com.sakthi.dev.TaskManager.Services;

import com.sakthi.dev.TaskManager.Model.User;
import com.sakthi.dev.TaskManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepositoryRepository;

    public User createUser(User user)
    {
        return userRepositoryRepository.save(user);
    }
    public User GetById(Long id)
    {
        return userRepositoryRepository.findById(id).orElseThrow(()->new RuntimeException());
    }
}
