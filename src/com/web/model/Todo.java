package com.web.model;

public class Todo {

    private String taskName;
    private int sequence;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Todo(String name, int seq) {
        this.taskName = name;
        this.sequence = seq;
    }
    public Todo() {}
}
