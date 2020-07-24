package com.repository;

import com.model.Sprint;
import com.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task addTaskToSprint(Task task, Sprint sprint);
    Task getTaskById(Long id);
}
