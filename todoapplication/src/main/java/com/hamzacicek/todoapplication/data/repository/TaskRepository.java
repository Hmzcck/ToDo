package com.hamzacicek.todoapplication.data.repository;

import com.hamzacicek.todoapplication.data.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    boolean existsByTitle(String title);
}