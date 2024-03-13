package com.codurance.training.tasks.Persistence.Console;

import java.io.PrintWriter;
import java.util.List;

public class ConsoleOutput {
    private final PrintWriter out;

    public ConsoleOutput(PrintWriter out) {
        this.out = out;
    }

    public void output() {
        out.print("> ");
        out.flush();
    }
    public void setOutputQueue(List<String> commandResult) {
        for(String result: commandResult){
            out.println(result);
        }
    }
}
