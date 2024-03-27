package com.codurance.training.tasks.Entity;

public class Project {
    private final ProjectName projectName;
    private final Tasks tasks;

    public Project(ProjectName projectName, Tasks tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.addTask(task);
    }
}
