package com.api.taskList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.taskList.models.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
    
}
