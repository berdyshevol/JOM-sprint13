package com.service;

import com.model.Sprint;
import com.model.Task;
import com.repository.TaskRepository;

import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTaskToSprint(Task task, Sprint sprint) {
        if (task.getId() != null) {
            taskRepository.getOne(sprint.getId());
        }
        taskRepository.save(task);
        task.setSprint(sprint);
        return task;
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }
}
