package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Projects {
    private final List<Project> projects = new ArrayList<>();
    private static long lastId = 0;

    public List<Project> getProjects() {
        return projects;
    }
    public List<Task> getTasks(ProjectName projectName){
        for(Project project: projects){
            if(project.getProjectName().equals(projectName)){
                return project.getTasks();
            }
        }
        return null;
    }

    public void addTask(ProjectName projectName, String description, boolean done){
        for(Project project : projects) {
            if(Objects.equals(project.getProjectName(), projectName)) {
                project.getTasks().add(new Task(nextId(), description, false));
            }
        }
    }

    public void addProject(ProjectName projectName, List<Task> tasks){
        this.projects.add(new Project(projectName, tasks));
    }

    public long nextId() {
        return ++lastId;
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
