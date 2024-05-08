package com.codurance.training.tasks.UseCase.Port.In.Projects.Help;

import tw.teddysoft.ezddd.core.usecase.Input;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface HelpUseCase extends Query<Input.NullInput, HelpOutput> {
}
