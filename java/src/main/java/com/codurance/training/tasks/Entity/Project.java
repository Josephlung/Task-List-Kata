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

    public List<String> setDone(TaskId taskId, boolean done) {
        List<String> results = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setDone(done);
                return null;
            }
        }
        results.add("Could not find a task with an ID of " + taskId.toString() + ".");
        results.add("\r\n");
        return results;
    }

    public boolean containTask(TaskId taskId) {
        return tasks.stream().anyMatch(task -> task.getId().equals(taskId));
    }
}
