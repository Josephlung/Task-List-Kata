package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class ShowCommand implements Command{
    private final PrintWriter out;
    private final TaskList taskList;

    public ShowCommand(TaskList taskList, PrintWriter out) {
        this.out = out;
        this.taskList = taskList;
    }

    @Override
    public void executeCommand(String command) {
        for (Project project : taskList.getProjects()) {
            out.println(project.getProjectName());
            for (Task task : project.getTasks()) {
                char teskStatus = ' ';
                if(task.isDone()) {
                    teskStatus = 'x';
                }
                out.printf("    [%c] %d: %s%n", teskStatus, task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
