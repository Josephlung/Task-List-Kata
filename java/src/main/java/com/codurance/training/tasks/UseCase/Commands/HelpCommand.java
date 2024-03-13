package com.codurance.training.tasks.UseCase.Commands;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command{
    private List<String> outputResult;

    public HelpCommand() {

    }

    @Override
    public List<String> getOutputResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        outputResult = new ArrayList<>();
        outputResult.add("Commands:");
        outputResult.add("  show");
        outputResult.add("  add project <project name>");
        outputResult.add("  add task <project name> <task description>");
        outputResult.add("  check <task ID>");
        outputResult.add("  uncheck <task ID>");
        outputResult.add("\r\n");
    }
}
