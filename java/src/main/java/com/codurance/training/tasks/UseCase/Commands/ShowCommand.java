package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command{
    private final List<Project> projects;
    public ShowCommand(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        List<String> outputResult = new ArrayList<>();
        for (Project project : projects) {
            outputResult.add(project.getProjectName().toString() + "\r\n");
            for (Task task : project.getTasks()) {
                char taskStatus = ' ';
                if(task.isDone()) {
                    taskStatus = 'x';
                }
                outputResult.add("    [" + taskStatus + "] " + task.getId() + ": " + task.getDescription() + "\r\n");
            }
            outputResult.add("\r\n");
        }
        return outputResult;
    }
}
