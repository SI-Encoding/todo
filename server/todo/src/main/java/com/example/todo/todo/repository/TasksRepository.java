package com.example.todo.todo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.todo.todo.model.Tasks;

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

    public Tasks getTaskById(String id) {
        for(Tasks task : tasks) { 
            if(task.getId().equals(id)) { 
            return task;
            }
         }
         return tasks.get(0);
    }

    public List<Tasks> getList() {
        return tasks;
    } 
}
