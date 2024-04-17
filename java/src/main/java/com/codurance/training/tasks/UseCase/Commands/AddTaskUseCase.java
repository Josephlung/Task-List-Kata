package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.AddTaskInput;

import java.util.ArrayList;
import java.util.List;

public class AddTaskUseCase {
    private final Projects projects;

    public AddTaskUseCase(Projects projects){
        this.projects = projects;
    }

    public List<String> execute(AddTaskInput input) {
        return addTask(ProjectName.of(input.projectName), input.description);
    }

    private List<String> addTask(ProjectName projectName, String description) {
        List<String> outputResult = new ArrayList<>();
        if(projects.hasProjectName(projectName)) {
            projects.addTask(projectName, description, false);
            return outputResult;
        }
        outputResult.add("Could not find a project with the name \"" + projectName + "\".");
        outputResult.add("\r\n");
        return outputResult;
    }
}
