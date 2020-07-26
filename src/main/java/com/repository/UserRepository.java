package com.repository;

import com.model.Marathon;
import com.model.Task;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> getAll();
//    User getUserById(Long id);
//    User createOrUpdateUser(User user);
    List<User> getAllByRole(User.Role role);
//    boolean addUserToMarathon(User user, Marathon marathon);
//    boolean addUserToTask(User user, Task task);
}
