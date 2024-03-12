package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;

import java.io.PrintWriter;
import java.util.List;

public class ShowCommand implements Command{
    private final PrintWriter out;
    private final List<Project> projects;

    public ShowCommand(PrintWriter out, List<Project> projects) {
        this.out = out;
        this.projects = projects;
    }

    @Override
    public void executeCommand(String command) {
        for (Project project : projects) {
            out.println(project.getProjectName());
            for (Task task : project.getTasks()) {
                char taskStatus = ' ';
                if(task.isDone()) {
                    taskStatus = 'x';
                }
                out.printf("    [%c] %d: %s%n", taskStatus, task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
