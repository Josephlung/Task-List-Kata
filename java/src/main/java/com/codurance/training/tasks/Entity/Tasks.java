package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasList() {
        return tasks.stream()
                .map(t -> (Task) new ReadOnlyTask(t.getId(), t.getDescription(), t.isDone()))
                .toList();
    }

    public void addTask(Task task) {
        tasks.add(task);
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
