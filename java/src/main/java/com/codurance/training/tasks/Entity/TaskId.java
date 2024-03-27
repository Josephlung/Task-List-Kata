package com.codurance.training.tasks.Entity;

public record TaskId(long value) {
    public static TaskId of(long id) {
        return new TaskId(id);
    }

    @Override
    public String toString(){
        return Long.toString(value);
    }
}
