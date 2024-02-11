package com.api.taskList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.api.taskList.models.Task;
import com.api.taskList.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //Get task
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //Create Task
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    //Update Task
    public Task updatTask(Task task){
        return taskRepository.save(task);
    }

    //Delete Task
    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

}
