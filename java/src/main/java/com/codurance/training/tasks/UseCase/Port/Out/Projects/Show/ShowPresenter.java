package com.codurance.training.tasks.UseCase.Port.Out.Projects.Show;

import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ProjectsDto;

public interface ShowPresenter {
    void present(ProjectsDto projectsDto);
}