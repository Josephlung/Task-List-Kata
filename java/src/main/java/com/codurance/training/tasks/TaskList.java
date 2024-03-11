package com.codurance.training.tasks;

import com.codurance.training.tasks.UseCase.Command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private final List<Project> projects = new ArrayList<>();
    private final BufferedReader in;
    private final PrintWriter out;
    private final Map<String, Command> commandMap;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        commandMap = new HashMap<>();
        commandMap.put("show", new ShowCommand(this, out));
        commandMap.put("add", new AddCommand(this, out));
        commandMap.put("check", new CheckCommand(this, out));
        commandMap.put("uncheck", new UncheckCommand(this, out));
        commandMap.put("help", new HelpCommand(out));
        commandMap.put("error", new ErrorCommand(out));
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    public List<Project> getProjects() {
        return projects;
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], commandMap.get("error"));
        if(commandRest.length > 1) {
            command.executeCommand(commandRest[1]);
        }else {
            command.executeCommand(commandLine);
        }
    }
}
