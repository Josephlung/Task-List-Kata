package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.UseCase.Commands.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private Map<String, Command> commandMap;
    private final PrintWriter out;
    private final List<Project> projects = new ArrayList<>();

    public Controller(PrintWriter out) {
        this.out = out;
        mapInit();
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], commandMap.get("error"));
        if(commandRest.length > 1) {
            command.executeCommand(commandRest[1]);
        }else {
            command.executeCommand(commandLine);
        }
    }
    private void mapInit() {
        commandMap = new HashMap<String, Command>();
        commandMap.put("show", new ShowCommand(out, projects));
        commandMap.put("add", new AddCommand(out, projects));
        commandMap.put("check", new CheckCommand(out, projects));
        commandMap.put("uncheck", new UncheckCommand(out, projects));
        commandMap.put("help", new HelpCommand(out));
        commandMap.put("error", new ErrorCommand(out));
    }
}
