package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class UncheckCommand implements Command{
    private final Projects projects;

    public UncheckCommand(Projects projects) {
        this.projects = projects;
    }
    @Override
    public List<String> executeCommand(String command) {
        return setFalse(command);
    }

    private List<String> setFalse(String idString) {
        List<String> outputResult = new ArrayList<>();
        int id = Integer.parseInt(idString);
        for (Project project : projects.getProjects()) {
            for (Task task : project.getTasks().getTasks()) {
                if (task.getId() == id) {
                    task.setDone(false);
                    return outputResult;
                }
            }
        }
        outputResult.add("Could not find a task with an ID of " + id + ".");
        outputResult.add("\r\n");
        return outputResult;
    }
}
