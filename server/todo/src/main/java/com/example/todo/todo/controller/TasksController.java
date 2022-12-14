package com.example.todo.todo.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.todo.todo.model.Tasks;
import com.example.todo.todo.repository.TasksRepository;

@Controller
public class TasksController {
    
    private final TasksRepository tasksRepository;

    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @SchemaMapping(typeName = "Query",value = "getList")
    public List<Tasks> getList() {
        return tasksRepository.getList();
    }

    @MutationMapping
    public Tasks createTask(@Argument("name") String name, @Argument("notes") String notes, @Argument("dueDate") String dueDate, @Argument("time") String time, @Argument("isComplete") Boolean isComplete) {
         tasksRepository.addToList(new Tasks(name, notes, dueDate, time, isComplete));
        return tasksRepository.getTask(tasksRepository.taskSize()-1);
    }
}