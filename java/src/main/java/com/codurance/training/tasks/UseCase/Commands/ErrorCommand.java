package com.codurance.training.tasks.UseCase.Commands;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand implements Command{
    public ErrorCommand() {
    }

    @Override
    public List<String> executeCommand(String command) {
        List<String> outputResult = new ArrayList<>();
        outputResult.add("I don't know what the command \"" + command + "\" is.");
        outputResult.add("\r\n");
        return outputResult;
    }
}
