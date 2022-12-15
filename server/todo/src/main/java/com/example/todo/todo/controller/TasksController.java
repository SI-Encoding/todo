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
    public Tasks createTask(@Argument("id") int id, @Argument("name") String name, @Argument("notes") String notes, @Argument("dueDate") String dueDate, @Argument("time") String time, @Argument("isComplete") Boolean isComplete) {
         tasksRepository.addToList(new Tasks(id, name, notes, dueDate, time, isComplete));
        return tasksRepository.getTaskById(id);
    }

    @MutationMapping
    public Tasks taskCompleted(@Argument("id") int id, @Argument("isComplete") Boolean isComplete) {
         Tasks task = tasksRepository.getTaskById(id);
         task.setIsComplete(true);
        return tasksRepository.getTaskById(id);
    }

}