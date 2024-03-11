package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class UncheckCommand implements Command{
    private final PrintWriter out;
    private final TaskList taskList;

    public UncheckCommand(TaskList taskList, PrintWriter out) {
        this.out = out;
        this.taskList = taskList;
    }
    @Override
    public void executeCommand(String command) {
        setFalse(command);
    }

    private void setFalse(String idString) {
        int id = Integer.parseInt(idString);
        for (Project project : taskList.getProjects()) {
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
