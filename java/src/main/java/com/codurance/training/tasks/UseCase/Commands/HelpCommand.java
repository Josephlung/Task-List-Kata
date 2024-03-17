package com.codurance.training.tasks.UseCase.Commands;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command{
    public HelpCommand() {

    }
    @Override
    public List<String> executeCommand(String command) {
        List<String> outputResult = new ArrayList<>();
        outputResult.add("Commands:\r\n");
        outputResult.add("  show\r\n");
        outputResult.add("  add project <project name>\r\n");
        outputResult.add("  add task <project name> <task description>\r\n");
        outputResult.add("  check <task ID>\r\n");
        outputResult.add("  uncheck <task ID>\r\n");
        outputResult.add("\r\n");
        return outputResult;
    }
}
