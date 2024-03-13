package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command{
    private final List<Project> projects;
    private List<String> outputResult;

    public ShowCommand(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public List<String> getOutputResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        outputResult = new ArrayList<>();
        for (Project project : projects) {
            outputResult.add(project.getProjectName());
            for (Task task : project.getTasks()) {
                char taskStatus = ' ';
                if(task.isDone()) {
                    taskStatus = 'x';
                }
                outputResult.add("    [" + taskStatus + "] " + task.getId() + ": " + task.getDescription());
            }
            outputResult.add("\r\n");
        }
    }
}
