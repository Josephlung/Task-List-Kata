package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.UseCase.Commands.*;
import com.codurance.training.tasks.UseCase.InputBoundary.InputBoundary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCaseInteractor implements InputBoundary {
    private final Projects projects;
    private static final ProjectsId DEFAULT_PROJECTS_ID = ProjectsId.of("001");
    public UseCaseInteractor() {
        projects = new Projects(DEFAULT_PROJECTS_ID);
    }
    public List<String> execute(InputData inputData) {
        String[] commandRest = inputData.getInputCommand().split(" ", 2);
        String[] subcommandRest;
        List<String> outputData = new ArrayList<>();
        switch (commandRest[0]) {
            case "show":
                outputData = new ShowCommand(projects).execute(null);
                break;
            case "add":
                subcommandRest = commandRest[1].split(" ", 2);
                if (subcommandRest[0].equals("project")) {
                    AddProjectInput input = new AddProjectInput();
                    input.projectName = subcommandRest[1];
                    outputData = new AddProjectUseCase(projects).execute(input);
                }
                else if (subcommandRest[0].equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    AddTaskInput input = new AddTaskInput();
                    input.projectName = projectTask[0];
                    input.description = projectTask[1];
                    outputData = new AddTaskUseCase(projects).execute(input);
                }
                break;
            case "check":
                SetDoneInput checkInput = new SetDoneInput();
                checkInput.id = commandRest[1];
                checkInput.done = true;
                outputData = new SetDoneUseCase(projects).execute(checkInput);
                break;
            case "uncheck":
                SetDoneInput uncheckInput = new SetDoneInput();
                uncheckInput.id = commandRest[1];
                uncheckInput.done = false;
                outputData = new SetDoneUseCase(projects).execute(uncheckInput);
                break;
            case "help":
                outputData = new HelpCommand().execute(null);
                break;
            default:
                ErrorInput input = new ErrorInput();
                input.commandLine = inputData.getInputCommand();
                outputData = new ErrorCommand().execute(input);
                break;
        }
        return outputData;
    }
}
