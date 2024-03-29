package com.codurance.training.tasks.Entity;

import java.util.*;

public class Projects {
    private final List<Project> projects = new ArrayList<>();
    private static TaskId lastId = new TaskId(0);

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void addTask(ProjectName projectName, String description, boolean done){
        for(Project project : projects) {
            if(Objects.equals(project.getProjectName(), projectName)) {
                project.addTask(new Task(nextId(), description, done));
            }
        }
    }

    public void addProject(ProjectName projectName, Tasks tasks){
        this.projects.add(new Project(projectName, tasks));
    }

    public TaskId nextId() {
        lastId = TaskId.of(lastId.value() + 1);
        return lastId;
    }

    public boolean hasProjectName(ProjectName projectName){
        for(Project project: projects){
            if(project.getProjectName().equals(projectName)){
                return true;
            }
        }
        return false;
    }
}
