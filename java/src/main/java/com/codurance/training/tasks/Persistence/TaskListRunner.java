package com.codurance.training.tasks.Persistence;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.InterfaceAdapter.Controller;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import com.codurance.training.tasks.UseCase.ProjectInMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    public static final ProjectsId DEFAULT_PROJECTS_ID = ProjectsId.of("001");

    public final static Projects projects = new Projects(DEFAULT_PROJECTS_ID);
    private final ProjectsRepository repository;
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ProjectsRepository repository = new ProjectInMemoryRepository();
        repository.save(projects);
        new TaskListRunner(in, out, repository).run();
    }

    public TaskListRunner(BufferedReader reader, PrintWriter writer, ProjectsRepository repository) {
        this.repository = repository;
        this.in = reader;
        this.out = writer;
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
            new Controller(projects, out, repository).execute(command);
        }
    }
}
