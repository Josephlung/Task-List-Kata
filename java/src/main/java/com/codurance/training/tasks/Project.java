package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final String projectName;
    private List<Task> tasks = new ArrayList<Task>();

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
