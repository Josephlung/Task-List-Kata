package com.codurance.training.tasks.Persistence;

import com.codurance.training.tasks.InterfaceAdapter.Controller;
import com.codurance.training.tasks.Persistence.Console.ConsoleInput;
import com.codurance.training.tasks.Persistence.Console.ConsoleOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final Controller controller;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        consoleInput = new ConsoleInput(reader);
        consoleOutput = new ConsoleOutput(writer);
        controller = new Controller();
    }

    public void run() {
        while (true) {
            consoleOutput.output();
            String command;
            try {
                command = consoleInput.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        controller.execute(commandLine);
    }
}
