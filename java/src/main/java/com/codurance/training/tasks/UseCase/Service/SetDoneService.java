package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.ProjectsId;
import com.codurance.training.tasks.Entity.TaskId;
import com.codurance.training.tasks.UseCase.Port.In.Task.SetDone.SetDoneInput;
import com.codurance.training.tasks.UseCase.Port.In.Task.SetDone.SetDoneUseCase;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import tw.teddysoft.ezddd.core.usecase.ExitCode;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.io.PrintWriter;

import static java.lang.String.format;

public class SetDoneService implements SetDoneUseCase {
    private final ProjectsRepository repository;
    private final PrintWriter out;

    public SetDoneService(ProjectsRepository repository, PrintWriter out){
        this.repository = repository;
        this.out = out;
    }

    public CqrsOutput execute(SetDoneInput setDoneInput) {
        TaskId taskId = TaskId.of(setDoneInput.taskId);
        Projects projects = (Projects)repository.findById(ProjectsId.of(setDoneInput.projectsId)).get();

        if (!projects.containTask(taskId)){
            out.print(format("Could not find a task with an ID of %s.", taskId.value()));
            out.print("\r\n");
            return CqrsOutput.create().setExitCode(ExitCode.FAILURE).setMessage(out.toString());
        }
        projects.setDone(taskId, setDoneInput.done);
        repository.save(projects);
        return CqrsOutput.create().setExitCode(ExitCode.SUCCESS).setMessage("");
    }
}
