package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command{
    private final List<Project> projects;
    private final List<String> outputResult;

    public ShowCommand(List<Project> projects) {
        this.projects = projects;
        this.outputResult = new ArrayList<>();
    }

    @Override
    public List<String> getOutputResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        for (Project project : projects) {
            outputResult.add(project.getProjectName());
            System.out.print(project.getProjectName() + "\n");
            for (Task task : project.getTasks()) {
                char taskStatus = ' ';
                if(task.isDone()) {
                    taskStatus = 'x';
                }
                outputResult.add("    [" + taskStatus + "] " + task.getId() + ": " + task.getDescription());
                System.out.print("    [" + taskStatus + "] " + task.getId() + ": " + task.getDescription() + "\n");
            }
            outputResult.add("\r\n");
            System.out.print("\r\n");
        }
    }
}
