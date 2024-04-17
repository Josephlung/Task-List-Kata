package com.codurance.training.tasks.UseCase.Commands;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand{
    public HelpCommand() {
    }
    public List<String> execute() {
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
