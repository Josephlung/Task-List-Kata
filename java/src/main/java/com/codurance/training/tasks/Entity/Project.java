package com.codurance.training.tasks.Entity;

import tw.teddysoft.ezddd.core.entity.Entity;

import java.util.List;

public class Project implements Entity<ProjectName>{
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

    @Override
    public ProjectName getId() {
        return projectName;
    }

    public List<String> setDone(String idString, boolean done) {
        return tasks.setDone(idString, done);
    }
}
