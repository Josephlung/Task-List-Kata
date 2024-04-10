package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.Entity.TaskId;

import java.util.ArrayList;
import java.util.List;

public class CheckCommand implements Command{
    private final Projects projects;

    public CheckCommand(Projects projects) {
        this.projects = projects;
    }

    @Override
    public List<String> executeCommand(String command) {
        return setTrue(command);
    }

    private List<String> setTrue(String idString) {
        return projects.setDone(idString, true);
    }
}
