package com.service;

import com.model.Marathon;
import com.model.Task;
import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;
    final private MarathonService marathonService;

    public UserServiceImpl(UserRepository userRepository, MarathonService marathonService) {
        this.userRepository = userRepository;
        this.marathonService = marathonService;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (!users.isEmpty()) {
            return users;
        }
        return new ArrayList<>();
    }
    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityNotFoundException("No user exist for given id");
        }
    }

    @Override
    public User createOrUpdateUser(User entity) {
        // add validator

        if (entity.getId() != null) {
            Optional<User> user = userRepository.findById(entity.getId());

            if (user.isPresent()) {
                User newUser = user.get();
                newUser.setEmail(entity.getEmail());
                newUser.setFirstName(entity.getFirstName());
                newUser.setLastName(entity.getLastName());
                newUser.setRole(entity.getRole());
                newUser.setPassword(entity.getPassword());
                return newUser;
            }
        }

        entity = userRepository.save(entity);
        return entity;
    }

    @Override
    public List<User> getAllByRole(String role) {
        return userRepository.getAllByRole(User.Role.valueOf(role.toUpperCase()));
    }

    @Override
    public boolean addUserToMarathon(User user, Marathon marathon) {return true;}

    @Override
    public boolean addUserToTask(User user, Task task) {return true;}
}
