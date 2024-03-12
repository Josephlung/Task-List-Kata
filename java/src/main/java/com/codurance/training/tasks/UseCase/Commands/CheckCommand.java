package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.io.PrintWriter;
import java.util.List;

public class CheckCommand implements Command{
    private final PrintWriter out;
    private final List<Project> projects;

    public CheckCommand(PrintWriter out, List<Project> projects) {
        this.out = out;
        this.projects = projects;
    }
    @Override
    public void executeCommand(String command) {
        setTrue(command);
    }

    private void setTrue(String idString) {
        int id = Integer.parseInt(idString);
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(true);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
