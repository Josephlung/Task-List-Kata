package com.codurance.training.tasks.UseCase.Command;

import java.io.PrintWriter;

public class ErrorCommand implements Command{
    private final PrintWriter out;

    public ErrorCommand(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void executeCommand(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
