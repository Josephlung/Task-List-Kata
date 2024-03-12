package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.UseCase.Commands.*;
import com.codurance.training.tasks.UseCase.InputPort.InputPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInteractor {
    private Map<String, Command> commandMap;
    private final List<Project> projects;

    public CommandInteractor() {
        projects = new ArrayList<>();
        mapInit();
    }

    public void execute(InputPort inputPort) {
        String[] commandRest = inputPort.getInputData().split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], commandMap.get("error"));
        if(commandRest.length > 1) {
            command.executeCommand(commandRest[1]);
        }else {
            command.executeCommand(inputPort.getInputData());
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
