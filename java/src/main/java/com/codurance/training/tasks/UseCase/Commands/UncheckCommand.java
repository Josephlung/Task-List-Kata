package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Projects;
import java.util.List;

public class UncheckCommand implements Command{
    private final Projects projects;
    public UncheckCommand(Projects projects) {
        this.projects = projects;
    }
    @Override
    public List<String> executeCommand(String command) {
        return setFalse(command);
    }

    private List<String> setFalse(String idString) {
        return projects.setDone(idString, false);
    }
}
