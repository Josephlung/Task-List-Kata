package com.codurance.training.tasks.UseCase.Port.In.Projects.Show;

import com.codurance.training.tasks.UseCase.Port.ProjectsDto;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
public class ShowOutput extends CqrsOutput<ShowOutput>{
    public ProjectsDto projectsDto;
}
