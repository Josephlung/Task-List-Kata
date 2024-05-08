package com.codurance.training.tasks.UseCase.Port;

import com.codurance.training.tasks.Entity.Projects;

public class ProjectsMapper {
    public static ProjectsDto toDto(Projects projects) {
        ProjectsDto projectsDto = new ProjectsDto();
        projectsDto.id = projects.getId().value();
        projectsDto.projectDots = ProjectMapper.toDto(projects.getProjects());
        return projectsDto;
    }
}