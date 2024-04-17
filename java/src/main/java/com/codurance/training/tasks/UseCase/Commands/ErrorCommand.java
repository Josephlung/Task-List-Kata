package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.UseCase.ErrorInput;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand {
    public ErrorCommand() {
    }

    public List<String> execute(ErrorInput command) {
        List<String> outputResult = new ArrayList<>();
        outputResult.add("I don't know what the command \"" + command.commandLine + "\" is.");
        outputResult.add("\r\n");
        return outputResult;
    }
}
