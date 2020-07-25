package com.service;

import com.repository.MarathonRepository;
import com.model.Marathon;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarathonServiceImpl implements MarathonService {

    final private MarathonRepository marathonRepository;

    public MarathonServiceImpl(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<Marathon> getAll() {
        List<Marathon> marathons = marathonRepository.findAll();
        if (!marathons.isEmpty()) {
            return marathons;
        }
        return new ArrayList<>();
    }

    @Override
    public Marathon getMarathonById(Long id) {
        Optional<Marathon> marathon = marathonRepository.findById(id);
        if(marathon.isPresent()){
            return marathon.get();
        } else {
            throw new EntityNotFoundException("No marathon with such id!");
        }
    }

    @Override
    public Marathon createOrUpdate(Marathon entity) {
        if (entity.getId() != null) {
            Optional<Marathon> marathon = marathonRepository.findById(entity.getId());
            if (marathon.isPresent()) {
                Marathon newMarathon = marathon.get();
                newMarathon.setTitle(entity.getTitle());
                newMarathon = marathonRepository.save(newMarathon);
                return newMarathon;
            }
        }
        entity = marathonRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteMarathonById(Long id) {
        Optional<Marathon> marathon = marathonRepository.findById(id);
        if (marathon.isPresent()) {
            marathonRepository.deleteById(id);
        } else throw new EntityNotFoundException("No marathon with such id!");
    }
}
