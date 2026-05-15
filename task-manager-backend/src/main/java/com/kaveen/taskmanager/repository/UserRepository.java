package com.kaveen.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaveen.taskmanager.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
