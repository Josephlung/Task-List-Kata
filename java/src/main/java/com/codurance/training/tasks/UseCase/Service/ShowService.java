package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowOutput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Show.ShowUseCase;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import com.codurance.training.tasks.UseCase.Port.ProjectsMapper;
import tw.teddysoft.ezddd.core.usecase.UseCaseFailureException;

public class ShowService implements ShowUseCase {
    private final ProjectsRepository repository;
    public ShowService(ProjectsRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShowOutput execute(ShowInput input) throws UseCaseFailureException {
        Projects projects = (Projects) repository.findById(ProjectsId.of(input.projectsId)).get();
        ShowOutput output = new ShowOutput();
        output.projectsDto = ProjectsMapper.toDto(projects);
        return output;
    }
}
