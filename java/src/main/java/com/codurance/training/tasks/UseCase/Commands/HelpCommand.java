package com.codurance.training.tasks.UseCase.Commands;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command{
    private final List<String> outputResult;

    public HelpCommand() {
        this.outputResult = new ArrayList<>();
    }

    @Override
    public List<String> getOutputResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        outputResult.add("Commands:");
        outputResult.add("  show");
        outputResult.add("  add project <project name>");
        outputResult.add("  add task <project name> <task description>");
        outputResult.add("  check <task ID>");
        outputResult.add("  uncheck <task ID>");
        outputResult.add("\r\n");

        System.out.print("Commands:");
        System.out.print("  show");
        System.out.print("  add project <project name>");
        System.out.print("  add task <project name> <task description>");
        System.out.print("  check <task ID>");
        System.out.print("  uncheck <task ID>");
        System.out.print("\r\n");
    }
}
