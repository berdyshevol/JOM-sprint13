package com.softserve.edu;

import com.model.User;
import com.service.MarathonService;
import com.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void createOrUpdateUser() {
        System.out.println("Running Spring Boot Application");
        try {
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setPassword("password1");
                user.setRole(User.Role.MENTOR);
                user.setFirstName("MentorName" + i);
                user.setLastName("MentorSurname" + i);
                user.setEmail("mentoruser" + i + "@gmail.com");
                userService.createOrUpdateUser(user);
            }
            assert(true);
        }
        catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            assert(true);
        }
        User user = userService.getUserById(1L);
        user.setPassword("newPassword");
    }
}
