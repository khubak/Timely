package com.timely.timely.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;

public interface TimelyRepo extends JpaRepository<Project, Long> {
    Project findByName(String name);
    Project findByDuration(Timestamp duration);
}