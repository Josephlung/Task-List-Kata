package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command {
    private final Projects projects;
    public AddCommand(Projects projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        List<String> outputResult = new ArrayList<>();
        String[] subcommandRest = command.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(ProjectName.of(subcommandRest[1]));
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            outputResult = addTask(ProjectName.of(projectTask[0]), projectTask[1]);
        }
        return  outputResult;
    }

    private void addProject(ProjectName name) {
        projects.addProject(name, new ArrayList<>());
    }

    private List<String> addTask(ProjectName projectName, String description) {
        List<String> outputResult = new ArrayList<>();
        if(projects.hasProjectName(projectName)) {
            projects.addTask(projectName, description, false);
            return outputResult;
        }
        outputResult.add("Could not find a project with the name \"" + projectName + "\".");
        outputResult.add("\r\n");
        return outputResult;
    }
}
