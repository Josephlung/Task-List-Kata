package com.codurance.training.tasks.Entity;

import tw.teddysoft.ezddd.core.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Project implements Entity<ProjectName>{
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
//        return tasks.stream()
//                .map(t -> (Task) new ReadOnlyTask(t.getId(), t.getDescription(), t.isDone()))
//                .toList();
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public ProjectName getId() {
        return projectName;
    }

    public List<String> setDone(String idString, boolean done) {
        List<String> results = new ArrayList<>();
        int id = Integer.parseInt(idString);
        for (Task task : tasks) {
            if (task.getId().equals(TaskId.of(id))) {
                task.setDone(done);
                return null;
            }
        }
        results.add("Could not find a task with an ID of " + idString + ".");
        results.add("\r\n");
        return results;
    }
}
