package com;

import com.model.User;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;


public class Application {
    @Autowired
    private final UserService userService;
//    private final MarathonService marathonService;
//    private final SprintService sprintService;
//    private final TaskService taskService;
//    private final ProgressService progressService;

//    public Application(UserService userService, MarathonService marathonService, SprintService sprintService, TaskService taskService, ProgressService progressService) {
    public Application(UserService userService) {
       this.userService = userService;
//        this.marathonService = marathonService;
//        this.sprintService = sprintService;
//        this.taskService = taskService;
//        this.progressService = progressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    public void run(String... args) throws Exception {
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
        }
        catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }
        User user = userService.getUserById(1L);
        user.setPassword("newPassword");
    }
}