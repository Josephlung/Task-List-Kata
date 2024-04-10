package com.codurance.training.tasks.Entity;

import java.util.List;

public class ReadOnlyProject extends Project{
    public ReadOnlyProject(ProjectName projectName, Tasks tasks) {
        super(projectName, tasks);
    }
}
