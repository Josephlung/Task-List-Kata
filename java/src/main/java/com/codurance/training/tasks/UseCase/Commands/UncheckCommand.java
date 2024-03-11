package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;

public class UncheckCommand implements Command{
    private final PrintWriter out;
    private final List<Project> projects;

    public UncheckCommand(PrintWriter out, List<Project> projects) {
        this.out = out;
        this.projects = projects;
    }
    @Override
    public void executeCommand(String command) {
        setFalse(command);
    }

    private void setFalse(String idString) {
        int id = Integer.parseInt(idString);
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(false);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
