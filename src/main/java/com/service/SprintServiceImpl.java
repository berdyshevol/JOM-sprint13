package com.service;

import com.model.Marathon;
import com.model.Sprint;
import com.repository.MarathonRepository;
import com.repository.SprintRepository;
import org.springframework.stereotype.Service;
import com.service.SprintService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

    final private SprintRepository sprintRepository;
    final private MarathonRepository marathonRepository;

    public SprintServiceImpl(SprintRepository sprintRepository, MarathonRepository marathonRepository) {
        this.sprintRepository = sprintRepository;
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<Sprint> getSprintsByMarathonId(Long id) {
        List<Sprint> sprints = sprintRepository.findByMarathon(id);
        if (!sprints.isEmpty()) {
            return sprints;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon) {
        if (sprint.getId() != null) {
            sprintRepository.getOne(sprint.getId());
            return true;
        }
        sprint = sprintRepository.save(sprint);
        sprint.setMarathon(marathon);
        return false;
    }

    @Override
    public boolean updateSprint(Sprint sprint) {
        if (sprint.getId() != null) {
            Optional<Sprint> sprints = sprintRepository.findById(sprint.getId());
            if (sprints.isPresent()) {
                Sprint newSprint = sprints.get();
                newSprint.setTitle(sprint.getTitle());
                newSprint.setStart(sprint.getStart());
                newSprint.setFinish(sprint.getFinish());
                newSprint = sprintRepository.save(newSprint);
                return true;
            }
        }
        sprint = sprintRepository.save(sprint);
        return false;
    }

    @Override
    public Sprint getSprintById(Long id) {
        Optional<Sprint> sprint = sprintRepository.findById(id);
        return sprint.orElse(null);
    }
}
