package com.kaveen.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaveen.taskmanager.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<TaskEntity> findAllTasksByUserId(@Param("userId") Long userId);
}
