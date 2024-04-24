package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.InterfaceAdapter.presenter.ShowConsolePresenter;
import com.codurance.training.tasks.Persistence.TaskListRunner;
import com.codurance.training.tasks.UseCase.Port.In.Error.ErrorInput;
import com.codurance.training.tasks.UseCase.Port.In.Project.Add.AddProjectInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowOutput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowUseCase;
import com.codurance.training.tasks.UseCase.Port.In.Task.Add.SetDoneInput;
import com.codurance.training.tasks.UseCase.Port.In.Task.SetDone.AddTaskInput;
import com.codurance.training.tasks.UseCase.Port.Out.Projects.Show.ShowPresenter;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import com.codurance.training.tasks.UseCase.Service.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
                    input.projectName = subcommandRest[1];
                    new AddProjectService(projects).execute(input);
                }
                else if (subcommandRest[0].equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    AddTaskInput input = new AddTaskInput();
                    input.projectName = projectTask[0];
                    input.description = projectTask[1];
                    new AddTaskService(projects).execute(input, out);
                }
                break;
            case "check":
                SetDoneInput checkInput = new SetDoneInput();
                checkInput.id = commandRest[1];
                checkInput.done = true;
                new SetDoneService(projects, out).setDone(checkInput);
                break;
            case "uncheck":
                SetDoneInput uncheckInput = new SetDoneInput();
                uncheckInput.id = commandRest[1];
                uncheckInput.done = false;
                new SetDoneService(projects, out).setDone(uncheckInput);
                break;
            case "help":
                new HelpService(out).execute();
                break;
            default:
                ErrorInput input = new ErrorInput();
                input.commandLine = commandLine;
                new ErrorService(out).execute(input);
                break;
        }
    }
}
