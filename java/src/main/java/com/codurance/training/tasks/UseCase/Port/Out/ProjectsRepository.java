package com.codurance.training.tasks.UseCase.Port.Out;

import com.codurance.training.tasks.Entity.Projects;

import java.util.Optional;

public interface  ProjectsRepository<ID> {
    Optional<Projects> findById(ID id);
    void save(Projects projects);

}
