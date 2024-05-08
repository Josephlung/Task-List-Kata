package com.codurance.training.tasks.UseCase.Port.In.Project.Add;

import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
import tw.teddysoft.ezddd.cqrs.usecase.command.Command;

public interface AddProjectUseCase extends Command<AddProjectInput, CqrsOutput> {

}
