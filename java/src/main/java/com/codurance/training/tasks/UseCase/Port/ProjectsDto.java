package com.codurance.training.tasks.UseCase.Port;

import java.util.ArrayList;
import java.util.List;

public class ProjectsDto {
    public String id;
    public List<ProjectDto> projectDots;
    public ProjectsDto() {
        this.projectDots = new ArrayList<>();
    }

}
