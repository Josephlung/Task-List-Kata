package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.UseCase.Commands.*;
import com.codurance.training.tasks.UseCase.InputPort.InputPort;
import com.codurance.training.tasks.UseCase.OutputPort.OutputData;
import com.codurance.training.tasks.UseCase.OutputPort.OutputPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {
    private Map<String, Command> commandMap;
    private final List<Project> projects;

    public CommandExecutor() {
        projects = new ArrayList<>();
        mapInit();
    }

    public List<String> execute(InputPort inputPort) {
        String[] commandRest = inputPort.getInputCommand().split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], commandMap.get("error"));
        if(commandRest.length > 1) {
            return command.executeCommand(commandRest[1]);
        }else {
            return command.executeCommand(inputPort.getInputCommand());
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
