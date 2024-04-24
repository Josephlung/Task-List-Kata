package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.Port.In.Task.SetDone.AddTaskInput;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AddTaskService {
    private final Projects projects;

    public AddTaskService(Projects projects){
        this.projects = projects;
    }

    public void execute(AddTaskInput input, PrintWriter out) {
        addTask(ProjectName.of(input.projectName), input.description, out);
    }

    private void addTask(ProjectName projectName, String description, PrintWriter out) {
        List<String> outputResult = new ArrayList<>();
        if(projects.hasProjectName(projectName)) {
            projects.addTask(projectName, description, false);
            return;
        }
        out.print("Could not find a project with the name \"" + projectName + "\".");
        out.print("\r\n");
    }
}
