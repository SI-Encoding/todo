package com.example.todo.todo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.todo.todo.model.Tasks;

import jakarta.annotation.PostConstruct;

@Repository
public class TasksRepository {

    private List<Tasks> tasks = new ArrayList<>();

    public void addToList(Tasks task) {
        tasks.add(task);
    }

    public void removeFromList(Tasks task) {
        tasks.remove(task);
    }

    public boolean taskIsEmpty() {
        return tasks.isEmpty();
    }

    public int taskSize() {
        return tasks.size();
    }

    public Tasks getTask(int i) {
        return tasks.get(i);
    }

    public Tasks getTaskById(int id) {
        for(Tasks task : tasks) { 
            if(task.getId()==id) { 
            return task;
            }
         }
         return tasks.get(0);
    }

    public List<Tasks> getList() {
        return tasks;
    }

    // @PostConstruct
    // private void init() {
    //     tasks.add(new Tasks("Pick up the trash", "This Thursday", "2022-05-05", false));
    //     tasks.add(new Tasks("Pick up ", "This Thursday", "2022-05-05", false));
    // }
    
}
