package com.codurance.training.tasks.UseCase.Port;

import com.codurance.training.tasks.Entity.Project;

import java.util.List;

public class ProjectMapper {
    public static ProjectDto toDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.name = project.getProjectName().value();
        projectDto.taskDtos = TaskMapper.toDto(project.getTasks());
        return projectDto;
    }
    public static List<ProjectDto> toDto(List<Project> projects) {
        return projects.stream().map(ProjectMapper::toDto).toList();
    }
}