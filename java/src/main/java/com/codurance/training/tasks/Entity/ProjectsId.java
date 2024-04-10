package com.codurance.training.tasks.Entity;

public record ProjectsId(String value) {
    public static ProjectsId of(String id) {
        return new ProjectsId(id);
    }
}
