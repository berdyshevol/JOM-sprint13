package com.service;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    final private UserRepository userRepository;
    final private MarathonService marathonService;

    public UserServiceImpl(UserRepository userRepository, MarathonService marathonService) {
        this.userRepository = userRepository;
        this.marathonService = marathonService;
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (!users.isEmpty()) {
            return users;
        }
        return new ArrayList<>();
    }
}
