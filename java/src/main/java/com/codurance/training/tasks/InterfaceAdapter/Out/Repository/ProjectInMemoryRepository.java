package com.codurance.training.tasks.InterfaceAdapter.Out.Repository;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectInMemoryRepository implements ProjectsRepository<ProjectsId> {
    private final List<Projects> store = new ArrayList<>();

    @Override
    public Optional<Projects> findById(ProjectsId projectsId) {
        return store.stream().filter( x -> x.getId().equals(projectsId)).findFirst();
    }

    @Override
    public void save(Projects projects) {
        store.remove(projects);
        store.add(projects);
    }
}
