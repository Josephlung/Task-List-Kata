package com.codurance.training.tasks.UseCase.Port.In.Task.Add;

import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
import tw.teddysoft.ezddd.cqrs.usecase.command.Command;

public interface AddTaskUseCase extends Command<AddTaskInput, CqrsOutput> {

}
