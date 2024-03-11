package com.codurance.training.tasks.UseCase.Command;

import java.io.PrintWriter;

public class HelpCommand implements Command{
    private final PrintWriter out;

    public HelpCommand(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void executeCommand(String command) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
