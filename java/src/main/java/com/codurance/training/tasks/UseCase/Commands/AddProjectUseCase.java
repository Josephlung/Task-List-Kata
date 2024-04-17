package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.AddProjectInput;

import java.util.ArrayList;
import java.util.List;

public class AddProjectUseCase {
    private final Projects projects;

    public AddProjectUseCase(Projects projects) {
        this.projects = projects;
    }

    public List<String> execute(AddProjectInput input) {
        projects.addProject(ProjectName.of(input.projectName), new ArrayList<>());
        return new ArrayList<>();
    }
}
