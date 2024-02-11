package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name ="tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String title;
    private String description;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel userId;

    
    //Getters and setters


    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public UserModel getUserId(){
        return userId;
    }

    public void setUserId(UserModel userId){
        this.userId = userId;
    }

}
