package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class CheckCommand implements Command{
    private final List<Project> projects;

    public CheckCommand(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        return setTrue(command);
    }

    private List<String> setTrue(String idString) {
        List<String> outputResult = new ArrayList<>();
        int id = Integer.parseInt(idString);
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(true);
                    return outputResult;
                }
            }
        }
        outputResult.add("Could not find a task with an ID of " + id + ".");
        outputResult.add("\r\n");
        return outputResult;
    }
}
