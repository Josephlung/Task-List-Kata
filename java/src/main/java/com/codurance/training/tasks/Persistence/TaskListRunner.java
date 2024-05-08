package com.codurance.training.tasks.Persistence;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.InterfaceAdapter.controller.Controller;
import com.codurance.training.tasks.InterfaceAdapter.presenter.HelpConsolePresenter;
import com.codurance.training.tasks.InterfaceAdapter.presenter.ShowConsolePresenter;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import com.codurance.training.tasks.InterfaceAdapter.Out.Repository.ProjectInMemoryRepository;
import com.codurance.training.tasks.UseCase.Service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    public static final ProjectsId DEFAULT_PROJECTS_ID = ProjectsId.of("001");

//    public final static Projects projects = new Projects(DEFAULT_PROJECTS_ID);
//    private final ProjectsRepository repository;
    private final BufferedReader in;
    private final PrintWriter out;

    private final Controller controller;

    public TaskListRunner(BufferedReader in,
                          PrintWriter out,
                          ShowService showUseCase,
                          ShowConsolePresenter showPresenter,
                          AddProjectService addProjectUseCase,
                          AddTaskService addTaskUseCase,
                          SetDoneService setDoneUseCase,
                          HelpService helpUseCase,
                          ErrorService errorUseCase) {
        this.in = in;
        this.out = out;
        this.controller = new Controller(
                out,
                showUseCase,
                showPresenter,
                addProjectUseCase,
                addTaskUseCase,
                setDoneUseCase,
                helpUseCase,
                errorUseCase
                );
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ProjectsRepository repository = new ProjectInMemoryRepository();
        repository.save(new Projects(DEFAULT_PROJECTS_ID));
        var showUseCase = new ShowService(repository);
        var showPresenter = new ShowConsolePresenter(out);
        var addProjectUseCase = new AddProjectService(repository);
        var addTaskUseCase = new AddTaskService(repository, out);
        var setDoneUseCase = new SetDoneService(repository, out);
        var helpUseCase = new HelpService(new HelpConsolePresenter(out));
        var errorUseCase = new ErrorService(out);

        new TaskListRunner(
                in,
                out,
                showUseCase,
                showPresenter,
                addProjectUseCase,
                addTaskUseCase,
                setDoneUseCase,
                helpUseCase,
                errorUseCase
        ).run();
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
            controller.execute(command);
        }
    }
}
