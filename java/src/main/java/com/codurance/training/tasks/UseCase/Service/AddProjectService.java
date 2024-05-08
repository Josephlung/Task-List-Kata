package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.*;
import com.codurance.training.tasks.UseCase.Port.In.Project.Add.AddProjectInput;
import com.codurance.training.tasks.UseCase.Port.In.Project.Add.AddProjectUseCase;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.util.ArrayList;
import java.util.Optional;

public class AddProjectService implements AddProjectUseCase {
    private final ProjectsRepository repository;

    public AddProjectService(ProjectsRepository repository) {
        this.repository = repository;
    }

    public CqrsOutput execute(AddProjectInput input) {

        Optional<Projects> projects = repository.findById(ProjectsId.of(input.projectId));
        projects.get().addProject(ProjectName.of(input.projectName), new ArrayList<Task>());
        repository.save(projects.get());

        return CqrsOutput.create().succeed().setId(input.projectName);
    }
}
