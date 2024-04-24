package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.Entity.TaskId;
import com.codurance.training.tasks.UseCase.Port.In.Task.Add.SetDoneInput;

import java.io.PrintWriter;

import static java.lang.Long.parseLong;

public class SetDoneService {
    private final Projects projects;
    private final PrintWriter out;

    public SetDoneService(Projects projects, PrintWriter out){
        this.projects = projects;
        this.out = out;
    }

    public void setDone(SetDoneInput setDoneInput) {
        TaskId id = TaskId.of(parseLong(setDoneInput.id));
        for (var project : projects.getProjects()) {
            for (Task task : project.getTasks()) {
                if (task.getId().equals(id)) {
                    task.setDone(setDoneInput.done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %s.", id);
        out.println();
    }
}
