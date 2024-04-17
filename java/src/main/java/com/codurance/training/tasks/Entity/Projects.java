package com.codurance.training.tasks.Entity;

import java.util.*;

import tw.teddysoft.ezddd.core.entity.AggregateRoot;
import tw.teddysoft.ezddd.core.entity.DomainEvent;

public class Projects extends AggregateRoot<ProjectsId, DomainEvent>{
    private final List<Project> projects;
    private static TaskId lastId = new TaskId(0);
    private final ProjectsId id;

    public Projects(ProjectsId id) {
        this.id = id;
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects.stream()
                .map(p -> (Project) new ReadOnlyProject(p.getProjectName(), p.getTasks()))
                .toList();
    }

    public void addTask(ProjectName projectName, String description, boolean done){
        for(Project project : projects) {
            if(Objects.equals(project.getProjectName(), projectName)) {
                project.addTask(new Task(nextId(), description, done));
            }
        }
    }

    public void addProject(ProjectName projectName, List<Task> tasks){
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

    public List<String> setDone(String idString, boolean done) {
        List<String> outputResult = new ArrayList<>();
        for (Project project : projects) {
            outputResult = project.setDone(idString, done);
            if(outputResult == null) {
                return new ArrayList<>();
            }
        }
        return outputResult;
    }

    @Override
    public ProjectsId getId() {
        return id;
    }
}
