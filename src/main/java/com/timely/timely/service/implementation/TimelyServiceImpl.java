package com.timely.timely.service.implementation;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static org.springframework.data.domain.PageRequest.of;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TimelyServiceImpl implements TimelyService {
    private final TimelyRepo timelyRepo;
    @Override
    public Project create(Project project) {
        log.info("Saving new project: {}", project.getName());
        project.setDateStarted(System.currentTimeMillis());
        return timelyRepo.save(project);
    }

    @Override
    public Collection<Project> list(int limit) {
        log.info("Fetching all projects:");
        return timelyRepo.findAll(of(0, limit)).toList();
    }

    @Override
    public Project get(Long id) {
        log.info("Fetching all projects by id: {}:", id);
        return timelyRepo.findById(id).get();
    }

    @Override
    public Project update(Project project) {
        log.info("Updating project with ID: {}", project.getName());
        return timelyRepo.save(project);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by ID: {}", id);
        timelyRepo.deleteById(id);
        return Boolean.TRUE;
    }

}
