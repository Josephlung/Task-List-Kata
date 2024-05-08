package com.codurance.training.tasks.InterfaceAdapter.controller;

import com.codurance.training.tasks.InterfaceAdapter.presenter.ShowConsolePresenter;
import com.codurance.training.tasks.Persistence.TaskListRunner;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Error.ErrorInput;
import com.codurance.training.tasks.UseCase.Port.In.Project.Add.AddProjectInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowOutput;
import com.codurance.training.tasks.UseCase.Port.In.Task.SetDone.SetDoneInput;
import com.codurance.training.tasks.UseCase.Port.In.Task.Add.AddTaskInput;
import com.codurance.training.tasks.UseCase.Service.*;
import tw.teddysoft.ezddd.core.usecase.Input;

import java.io.PrintWriter;

public class Controller {
    private final PrintWriter out;
    private final ShowService showUseCase;
    private final ShowConsolePresenter showPresenter;
    private final AddProjectService addProjectUseCase;
    private final AddTaskService addTaskUseCase;
    private final SetDoneService setDoneUseCase;
    private final HelpService helpUseCase;
    private final ErrorService errorUseCase;
    public Controller(PrintWriter out,
                      ShowService showUseCase,
                      ShowConsolePresenter showPresenter,
                      AddProjectService addProjectUseCase,
                      AddTaskService addTaskUseCase,
                      SetDoneService setDoneUseCase,
                      HelpService helpUseCase,
                      ErrorService errorUseCase) {
        this.out = out;
        this.showUseCase = showUseCase;
        this.showPresenter = showPresenter;
        this.addProjectUseCase = addProjectUseCase;
        this.addTaskUseCase = addTaskUseCase;
        this.setDoneUseCase = setDoneUseCase;
        this.helpUseCase = helpUseCase;
        this.errorUseCase = errorUseCase;
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] subcommandRest;
        switch (commandRest[0]) {
            case "show":
                ShowInput showInput = new ShowInput();
                showInput.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                ShowOutput output = showUseCase.execute(showInput);
                showPresenter.present(output.projectsDto);
                break;
            case "add":
                subcommandRest = commandRest[1].split(" ", 2);
                if (subcommandRest[0].equals("project")) {
                    AddProjectInput input = new AddProjectInput();
                    input.projectId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                    input.projectName = subcommandRest[1];
                    addProjectUseCase.execute(input);
                }
                else if (subcommandRest[0].equals("task")) {
                    String[] subcommand = subcommandRest[1].split(" ", 2);
                    AddTaskInput input = new AddTaskInput();
                    input.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                    input.projectName = subcommand[0];
                    input.description = subcommand[1];
                    addTaskUseCase.execute(input);
                }
                break;
            case "check":
                SetDoneInput checkInput = new SetDoneInput();
                checkInput.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                checkInput.taskId = commandRest[1];
                checkInput.done = true;
                setDoneUseCase.execute(checkInput);
                break;
            case "uncheck":
                SetDoneInput uncheckInput = new SetDoneInput();
                uncheckInput.projectsId = TaskListRunner.DEFAULT_PROJECTS_ID.value();
                uncheckInput.taskId = commandRest[1];
                uncheckInput.done = false;
                setDoneUseCase.execute(uncheckInput);
                break;
            case "help":
                helpUseCase.execute(new Input.NullInput());
                break;
            default:
                ErrorInput input = new ErrorInput();
                input.commandLine = commandLine;
                errorUseCase.execute(input);
                break;
        }
    }
}
