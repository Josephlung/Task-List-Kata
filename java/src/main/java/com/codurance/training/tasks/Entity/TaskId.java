package com.codurance.training.tasks.Entity;

public record TaskId(String value) {
    public static TaskId of(long id) {
        return new TaskId(Long.toString(id));
    }

    public static TaskId of(String id) {
        return new TaskId(id);
    }

    @Override
    public String toString(){
        return value;
    }
}
