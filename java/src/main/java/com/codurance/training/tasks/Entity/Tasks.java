package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Tasks {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasList() {
        return Collections.unmodifiableList(tasks);
    }

    public void add(Task task) {
        tasks.add(task);
    }
}
