package com.codurance.training.tasks.Entity;

import java.util.List;

public class Project {
    private final ProjectName projectName;
    private final List<Task> tasks;

    public Project(ProjectName projectName, List<Task> tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
