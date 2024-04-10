package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.UseCase.Commands.*;
import com.codurance.training.tasks.UseCase.InputBoundary.InputBoundary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCaseInteractor implements InputBoundary {
    private final Projects projects;
    private Map<String, Command> commandMap;
    private static final ProjectsId DEFAULT_PROJECTS_ID = ProjectsId.of("001");
    public UseCaseInteractor() {
        projects = new Projects(DEFAULT_PROJECTS_ID);
        mapInit();
    }
    public List<String> execute(InputData inputData) {
        String[] commandRest = inputData.getInputCommand().split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], commandMap.get("error"));
        if(commandRest.length > 1) {
            return command.executeCommand(commandRest[1]);
        }else {
            return command.executeCommand(inputData.getInputCommand());
        }
    }

    private void mapInit() {
        commandMap = new HashMap<String, Command>();
        commandMap.put("show", new ShowCommand(projects));
        commandMap.put("add", new AddCommand(projects));
        commandMap.put("check", new CheckCommand(projects));
        commandMap.put("uncheck", new UncheckCommand(projects));
        commandMap.put("help", new HelpCommand());
        commandMap.put("error", new ErrorCommand());
    }
}
