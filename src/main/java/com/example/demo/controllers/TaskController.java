package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.TaskModel;
import com.example.demo.services.TaskService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping()
    public ArrayList<TaskModel> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping()
    public TaskModel createTask(@RequestBody TaskModel task){
        return this.taskService.createTask(task);
    }

    @GetMapping(path = "/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable("id") Long id){
        return taskService.getById(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.taskService.deleteTask(id);
        if(ok){
            return "The taks with the id " + id + " has been deleted successfully";
        }else{
            return "The task with the id " + id + " couldnt be deleted";
        }
    }

}
