package com.codurance.training.tasks.UseCase.Port.In.Task.SetDone;

import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
import tw.teddysoft.ezddd.cqrs.usecase.command.Command;

public interface SetDoneUseCase extends Command<SetDoneInput, CqrsOutput> {
}
