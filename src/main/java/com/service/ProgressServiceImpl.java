package com.service;

import com.model.Progress;
import com.model.Task;
import com.model.User;
import com.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProgressServiceImpl implements ProgressService {

    final private ProgressRepository progressRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Override
    public Progress getProgressById(Long id) {
        Optional<Progress> sprint = progressRepository.findById(id);
        return sprint.orElse(null);
    }

    @Override
    public Progress addTaskForStudent(Task task, User user) {
        return null;
    }

    @Override
    public Progress addOrUpdateProgress(Progress p) {
        if (p.getId() != null) {
            Optional<Progress> progress = progressRepository.findById(p.getId());
            if (progress.isPresent()) {
                Progress newProgress = progress.get();
                newProgress.setStarted(p.getStarted());
                newProgress.setUpdated(p.getUpdated());
                newProgress.setStatus(p.getStatus());
                newProgress = progressRepository.save(newProgress);
                return newProgress;
            }
        }
        p = progressRepository.save(p);
        return p;
    }

    @Override
    public List<Progress> allProgressByUserIdAndMarathonId(Long userId, Long marathonId) {
        return null;
    }

    @Override
    public List<Progress> allProgressByUserIdAndSprintId(Long userId, Long sprintId) {
        return null;
    }
}
