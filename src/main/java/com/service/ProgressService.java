package com.service;

import com.model.Progress;
import com.model.Task;
import com.model.User;

import java.util.List;

public interface ProgressService {
    Progress getProgressById(Long id);
    Progress addTaskForStudent(Task task, User user); // !!
    Progress addOrUpdateProgress(Progress progress);
//    boolean setStatus(Task task, Progress progress); // !!
    List<Progress> allProgressByUserIdAndMarathonId(Long userId, Long marathonId); // !!
    List<Progress> allProgressByUserIdAndSprintId(Long userId, Long springId);
}
