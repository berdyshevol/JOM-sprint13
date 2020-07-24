package com.repository;

import com.model.Progress;
import com.model.Task;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Process, Long> {
    Progress getProcessById(Long id);
    Progress addTaskForStudent(Task task, User user); // !!
    Progress addOrUpdateProgress(Progress progress);
    boolean setStatus(Task task, Progress progress); // !!
    List<Progress> allProgressByUserIdAndMarathonId(Long userId, Long marathonId); // !!
    List<Progress> allProgressByUserIdAndSpringId(Long userId, Long springId);
}
