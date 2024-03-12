package com.codurance.training.tasks.Entity;

import java.util.List;

public class Project {
    private final String projectName;
    private final List<Task> tasks;

    public Project(String projectName, List<Task> tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
