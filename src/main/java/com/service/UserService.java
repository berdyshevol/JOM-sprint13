package com.service;

import com.model.Marathon;
import com.model.Task;
import com.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(Long id);
    User createOrUpdateUser(User user);
    List<User> getAllByRole(String role);
    boolean addUserToMarathon(User user, Marathon marathon);
    boolean addUserToTask(User user, Task task);
}
