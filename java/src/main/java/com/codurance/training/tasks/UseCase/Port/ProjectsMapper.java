package com.codurance.training.tasks.UseCase.Port;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ProjectsDto;

public class ProjectsMapper {
    public static ProjectsDto toDto(Projects projects) {
        ProjectsDto projectsDto = new ProjectsDto();
        projectsDto.id = projects.getId().value();
        projectsDto.projectDots = ProjectMapper.toDto(projects.getProjects());
        return projectsDto;
    }
}