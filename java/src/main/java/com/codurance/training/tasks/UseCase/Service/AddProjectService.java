package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.Port.In.Project.Add.AddProjectInput;

import java.util.ArrayList;

public class AddProjectService {
    private final Projects projects;

    public AddProjectService(Projects projects) {
        this.projects = projects;
    }

    public void execute(AddProjectInput input) {
        projects.addProject(ProjectName.of(input.projectName), new ArrayList<>());
    }
}
