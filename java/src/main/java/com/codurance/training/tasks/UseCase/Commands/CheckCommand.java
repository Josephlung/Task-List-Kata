package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class CheckCommand implements Command{
    private final List<Project> projects;
    private final List<String> outputResult;

    public CheckCommand(List<Project> projects) {
        this.projects = projects;
        this.outputResult = new ArrayList<>();
    }

    @Override
    public List<String> getCommandResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        setTrue(command);
    }

    private void setTrue(String idString) {
        int id = Integer.parseInt(idString);
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(true);
                    return;
                }
            }
        }
        outputResult.add("Could not find a task with an ID of " + id + ".");
        outputResult.add("\r\n");
    }
}
