package com.codurance.training.tasks.Persistence.Console;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInput {
    private final BufferedReader in;

    public ConsoleInput(BufferedReader in){
        this.in = in;
    }

    public String readLine() throws IOException {
        return in.readLine();
    }
}
