package com.service;

import com.model.Marathon;
import com.model.Sprint;

import java.util.List;

public interface SprintService {
    List<Sprint> getSprintByMarathonId(Long id);
    boolean addSprintToMarathon(Sprint sprint, Marathon marathon);
    boolean updateSprint(Sprint sprint);
    Sprint getSprintById(Long id);
}
