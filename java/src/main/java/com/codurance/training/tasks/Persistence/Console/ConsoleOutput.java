package com.codurance.training.tasks.Persistence.Console;

import java.io.PrintWriter;

public class ConsoleOutput {
    private final PrintWriter out;

    public ConsoleOutput(PrintWriter out) {
        this.out = out;
    }

    public void output() {
        out.print("> ");
        out.flush();
    }
}
