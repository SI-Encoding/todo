package com.example.todo.todo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.example.todo.todo.model.Tasks;
import com.example.todo.todo.repository.TasksRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@GraphQlTest(TasksController.class)
public class TasksControllerTest {
    
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private TasksRepository tasksRepository;

    private final List<Tasks> tasks = new ArrayList<>();

    @Test
    public void contextLoads() {
        assertNotNull(graphQlTester);
        assertNotNull(tasksRepository);
    }

    @BeforeEach
    void setUp() {
        tasks.add(new Tasks("Pick up the trash", "This Thursday", "2022-05-05", false));
        tasks.add(new Tasks("Finish assigment", "Research economics 101 Supply & Demand", "2022-05-05", false));
        tasks.add(new Tasks("Water garden", "Make sure to extra water the sunflowers", "2022-05-05", false));
    }

    @Test
    void testGetListTasksQueryReturnsAllTasks() {
        String document = """
            query {
                getList {
                    name
                    notes
                    dueDate
                    isComplete
                }
            }        
        """;

        when(tasksRepository.getList()).thenReturn(tasks);

        graphQlTester.document(document)
                .execute()
                .path("getList")
                .entityList(Tasks.class)
                .hasSize(3);
    }
}