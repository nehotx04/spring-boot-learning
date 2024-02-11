package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// import java.util.ArrayList;

import com.example.demo.models.TaskModel;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel,Long>{
    System.out.println(TaskModel);
    // public abstract ArrayList<TaskModel> findByUserId(Long userId);
}

