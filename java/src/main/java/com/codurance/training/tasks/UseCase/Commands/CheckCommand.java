package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.Entity.TaskId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckCommand implements Command{
    private final Projects projects;

    public CheckCommand(Projects projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        return setTrue(command);
    }

    private List<String> setTrue(String idString) {
        List<String> outputResult = new ArrayList<>();
        int id = Integer.parseInt(idString);
        for (Project project : projects.getProjects()) {
            for (Task task : project.getTasks().getTasList()) {
                if (task.getId().equals(TaskId.of(id))) {
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
