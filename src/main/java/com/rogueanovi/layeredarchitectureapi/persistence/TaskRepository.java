package com.rogueanovi.layeredarchitectureapi.persistence;

import com.rogueanovi.layeredarchitectureapi.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
