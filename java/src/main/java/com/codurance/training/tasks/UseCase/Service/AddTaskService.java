package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.UseCase.Port.In.Task.Add.AddTaskInput;
import com.codurance.training.tasks.UseCase.Port.In.Task.Add.AddTaskUseCase;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.io.PrintWriter;

public class AddTaskService implements AddTaskUseCase {
    private final ProjectsRepository repository;
    private final PrintWriter out;
    public AddTaskService(ProjectsRepository repository, PrintWriter out){
        this.repository = repository;
        this.out = out;
    }

    public CqrsOutput execute(AddTaskInput input) {
        return addTask(ProjectsId.of(input.projectsId), ProjectName.of(input.projectName), input.description);
    }

    private CqrsOutput addTask(ProjectsId projectsId, ProjectName projectName, String description) {
        Projects projects = (Projects)repository.findById(projectsId).get();
        if(projects.hasProjectName(projectName)) {
            projects.addTask(projectName, description, false);
            return CqrsOutput.create().succeed().setId(projectName.toString());
        }
        out.print("Could not find a project with the name \"" + projectName + "\".");
        out.print("\r\n");
        return CqrsOutput.create().fail().setMessage(out.toString());
    }
}
