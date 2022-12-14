package com.example.todo.todo.model;

public class Tasks {
    
    private String name;

    private String notes;

    private String dueDate;

    private boolean isComplete;

    public Tasks(String name, String notes, String dueDate, boolean isComplete) {
        this.name = name;
        this.notes = notes;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
    }

    public String getName() {

        return this.name;

    }

    public String getNotes() {
        
        return this.notes;

    }

    public String getDueDate() {
        
        return this.dueDate;
        
    }

    public void setIsComplete(boolean isComplete) {

        this.isComplete = isComplete;
    }


    public String isItComplete() {

        if (!isComplete) {
            return "No";
        } else {
            return "Yes";
        }
    }

    public boolean getIsComplete() {

        return this.isComplete;

    }

   
}
