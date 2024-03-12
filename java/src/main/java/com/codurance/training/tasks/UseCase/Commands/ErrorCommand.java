package com.codurance.training.tasks.UseCase.Commands;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand implements Command{
    private final List<String> outputResult;

    public ErrorCommand() {
        this.outputResult = new ArrayList<>();
    }

    @Override
    public List<String> getOutputResult() {
        return outputResult;
    }

    @Override
    public void executeCommand(String command) {
        outputResult.add("I don't know what the command \"" + command + "\" is.");
        outputResult.add("\r\n");
        System.out.print("I don't know what the command \"" + command + "\" is.");
        System.out.print("\r\n");
    }
}
