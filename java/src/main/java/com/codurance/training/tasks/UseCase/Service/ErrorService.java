package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.UseCase.Port.In.Error.ErrorInput;

import java.io.PrintWriter;

public class ErrorService {
    private final PrintWriter out;
    public ErrorService(PrintWriter out) {
        this.out = out;
    }

    public void execute(ErrorInput command) {
        out.print("I don't know what the command \"" + command.commandLine + "\" is.");
        out.print("\r\n");
    }
}
