package com.codurance.training.tasks.InterfaceAdapter.controller;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.InterfaceAdapter.presenter.HelpConsolePresenter;
import com.codurance.training.tasks.InterfaceAdapter.presenter.ShowConsolePresenter;
import com.codurance.training.tasks.Persistence.TaskListRunner;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Error.ErrorInput;
import com.codurance.training.tasks.UseCase.Port.In.Project.Add.AddProjectInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Help.HelpUseCase;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowOutput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowUseCase;
import com.codurance.training.tasks.UseCase.Port.In.Task.SetDone.SetDoneInput;
import com.codurance.training.tasks.UseCase.Port.In.Task.Add.AddTaskInput;
import com.codurance.training.tasks.UseCase.Port.Out.Projects.Show.ShowPresenter;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import com.codurance.training.tasks.UseCase.Service.*;
import tw.teddysoft.ezddd.core.usecase.Input;

import java.io.PrintWriter;

public class Controller {
    private final Projects projects;
    private final PrintWriter out;
    private final ProjectsRepository repository;

    public Controller(Projects projects, PrintWriter out, ProjectsRepository repository) {
        this.projects = projects;
        this.out = out;
        this.repository = repository;
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] subcommandRest;
        switch (commandRest[0]) {
            case "show":
                ShowUseCase showUseCase = new ShowService(repository);
                ShowInput showInput = new ShowInput();
                showInput.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                ShowOutput output = showUseCase.execute(showInput);
                ShowPresenter presenter = new ShowConsolePresenter(out);
                presenter.present(output.projectsDto);
                break;
            case "add":
                subcommandRest = commandRest[1].split(" ", 2);
                if (subcommandRest[0].equals("project")) {
                    AddProjectInput input = new AddProjectInput();
                    input.projectId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                    input.projectName = subcommandRest[1];
                    new AddProjectService(repository).execute(input);
                }
                else if (subcommandRest[0].equals("task")) {
                    String[] subcommand = subcommandRest[1].split(" ", 2);
                    AddTaskInput input = new AddTaskInput();
                    input.projectName = subcommand[0];
                    input.description = subcommand[1];
                    new AddTaskService(projects, out).execute(input);
                }
                break;
            case "check":
                SetDoneInput checkInput = new SetDoneInput();
                checkInput.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                checkInput.taskId = commandRest[1];
                checkInput.done = true;
                new SetDoneService(repository, out).execute(checkInput);
                break;
            case "uncheck":
                SetDoneInput uncheckInput = new SetDoneInput();
                uncheckInput.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                uncheckInput.taskId = commandRest[1];
                uncheckInput.done = false;
                new SetDoneService(repository, out).execute(uncheckInput);
                break;
            case "help":
                HelpUseCase helpUseCase = new HelpService(new HelpConsolePresenter(out));
                helpUseCase.execute(new Input.NullInput());
                break;
            default:
                ErrorInput input = new ErrorInput();
                input.commandLine = commandLine;
                new ErrorService(out).execute(input);
                break;
        }
    }
}
