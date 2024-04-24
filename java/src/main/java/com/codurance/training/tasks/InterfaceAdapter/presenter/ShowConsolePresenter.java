package com.codurance.training.tasks.InterfaceAdapter.presenter;

import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ProjectDto;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ProjectsDto;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.TaskDto;
import com.codurance.training.tasks.UseCase.Port.Out.Projects.Show.ShowPresenter;
import java.io.PrintWriter;

public class ShowConsolePresenter implements ShowPresenter {
    private final PrintWriter out;

    public ShowConsolePresenter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void present(ProjectsDto projectsDto) {
        for (ProjectDto project : projectsDto.projectDots) {
            out.println(project.name);
            for (TaskDto task : project.taskDtos) {
                out.printf("    [%c] %s: %s%n", (task.done? 'x' : ' '), task.id, task.description);
            }
            out.println();
        }
    }
}
