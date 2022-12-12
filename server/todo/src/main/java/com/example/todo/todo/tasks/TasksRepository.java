package com.example.todo.todo.tasks;

import java.util.ArrayList;
import java.util.List;

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

    public List<Tasks> getList() {
        return tasks;
    }
    
}
