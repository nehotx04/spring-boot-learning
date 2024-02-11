package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TaskModel;
import com.example.demo.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public ArrayList<TaskModel> getTasks(){
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public TaskModel createTask(TaskModel task){
        return taskRepository.save(task);
    }

    public Optional<TaskModel> getById(Long id){
        return taskRepository.findById(id);
    }

    public boolean deleteTask(Long id){
        try{
            taskRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


}
