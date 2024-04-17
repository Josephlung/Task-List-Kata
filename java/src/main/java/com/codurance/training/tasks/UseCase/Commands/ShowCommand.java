package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command{
    private final Projects projects;
    public ShowCommand(Projects projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        List<String> outputResult = new ArrayList<>();
        for (Project project : projects.getProjects()) {
            outputResult.add(project.getProjectName().toString() + "\r\n");
            for (Task task : project.getTasks()) {
                outputResult.add("    [" + (task.isDone() ? 'x' : ' ') + "] " + task.getId() + ": " + task.getDescription() + "\r\n");
            }
            outputResult.add("\r\n");
        }
        return outputResult;
    }
}
