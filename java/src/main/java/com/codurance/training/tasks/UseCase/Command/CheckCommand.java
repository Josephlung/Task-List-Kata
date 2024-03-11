package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class CheckCommand implements Command{
    private final PrintWriter out;
    private final TaskList taskList;

    public CheckCommand(TaskList taskList, PrintWriter out) {
        this.out = out;
        this.taskList = taskList;
    }
    @Override
    public void executeCommand(String command) {
        setTrue(command);
    }

    private void setTrue(String idString) {
        int id = Integer.parseInt(idString);
        for (Project project : taskList.getProjects()) {
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
