package com.example.demo.models;

import java.util.LinkedList;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String name;
    private String email;
    private Integer priority;

    @OneToMany
    private LinkedList<TaskModel> taskList;
    

    public void setPriority(Integer priority){
        this.priority = priority;
    }

    public Integer getPriority(){
        return priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<TaskModel> getTaskList() { 
        return taskList;
    }
    public void setTaskList(LinkedList<TaskModel> taskList) { 
        this.taskList = taskList; 
    }
}
