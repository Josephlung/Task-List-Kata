package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class UncheckCommand implements Command{
    private final List<Project> projects;
    private final List<String> outputResult;

    public UncheckCommand(List<Project> projects) {
        this.projects = projects;
        this.outputResult = new ArrayList<>();
    }

    @Override
    public List<String> getOutputResult() {
        return null;
    }

    @Override
    public void executeCommand(String command) {
        setFalse(command);
    }

    private void setFalse(String idString) {
        int id = Integer.parseInt(idString);
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(false);
                    return;
                }
            }
        }
        outputResult.add("Could not find a task with an ID of " + id + ".");
        outputResult.add("\r\n");
    }
}
