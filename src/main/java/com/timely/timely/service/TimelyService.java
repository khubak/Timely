package com.timely.timely.service;

import java.util.Collection;


public interface TimelyService {
    Project create(Project project);
    Collection<Project> list(int limit);
    Project get(Long id);
    Project update(Project project);
    Boolean delete(Long id);
};
