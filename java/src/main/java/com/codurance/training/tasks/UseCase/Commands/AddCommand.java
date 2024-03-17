package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddCommand implements Command {
    private long lastId = 0;
    private final List<Project> projects;
    public AddCommand(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        List<String> outputResult = new ArrayList<>();
        String[] subcommandRest = command.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            outputResult = addTask(projectTask[0], projectTask[1]);
        }
        return  outputResult;
    }

    private void addProject(String name) {
        projects.add(new Project(name, new ArrayList<>()));
    }

    private List<String> addTask(String projectName, String description) {
        List<String> outputResult = new ArrayList<>();
        for(Project project : projects) {
            if(Objects.equals(project.getProjectName(), projectName)) {
                project.getTasks().add(new Task(nextId(), description, false));
                return outputResult;
            }
        }
        outputResult.add("Could not find a project with the name \"" + projectName + "\".");
        outputResult.add("\r\n");
        return outputResult;
    }

    private long nextId() {
        return ++lastId;
    }
}
