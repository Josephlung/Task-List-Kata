package com.codurance.training.tasks.UseCase.Commands;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.SetDoneInput;

import java.util.List;

public class SetDoneUseCase {
    private final Projects projects;

    public SetDoneUseCase(Projects projects){
        this.projects = projects;
    }

    public List<String> execute(SetDoneInput input) {
        return projects.setDone(input.id, input.done);
    }
}
