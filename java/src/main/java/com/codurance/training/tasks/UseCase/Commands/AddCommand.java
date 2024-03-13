package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddCommand implements Command {
    private long lastId = 0;
    private final List<Project> projects;
    private List<String> outputResult;

    public AddCommand(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public List<String> getCommandResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        outputResult = new ArrayList<>();
        String[] subcommandRest = command.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        projects.add(new Project(name, new ArrayList<>()));
    }

    private void addTask(String projectName, String description) {
        for(Project project : projects) {
            if(Objects.equals(project.getProjectName(), projectName)) {
                project.getTasks().add(new Task(nextId(), description, false));
                return;
            }
        }
        outputResult.add("Could not find a project with the name \"" + projectName + "\".");
        outputResult.add("\r\n");
    }

    private long nextId() {
        return ++lastId;
    }
}
