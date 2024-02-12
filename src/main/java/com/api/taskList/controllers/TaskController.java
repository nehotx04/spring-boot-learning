package com.api.taskList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.taskList.models.Task;
import com.api.taskList.models.User;
import com.api.taskList.repositories.TaskRepository;
import com.api.taskList.repositories.UserRepository;
import com.api.taskList.requests.TaskRequest;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Task> getAll(){
        return taskRepository.findAll();
    }
    
    @PostMapping()
    public String createTask(@RequestBody TaskRequest request){
        User user = userRepository.findById(request.getUserId()).orElse(null);
        if (user != null) {
            // Crear la tarea y establecer la conexión con el usuario
            Task newTask = new Task();
            System.out.println(request.getTitle());
            System.out.println(request.getDescription());
            newTask.setTitle(request.getTitle());
            newTask.setDescription(request.getDescription());
            newTask.setUser(user);

            // Guardar la nueva tarea en la base de datos
            taskRepository.save(newTask);
            return "User created successfully";
        }else{
            return "Error";
        }
    }
}
