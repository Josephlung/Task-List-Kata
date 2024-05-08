package com.codurance.training.tasks.UseCase.Port.In.Projects.Error;

import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
import tw.teddysoft.ezddd.cqrs.usecase.query.Query;

public interface ErrorUseCase extends Query<ErrorInput, CqrsOutput> {

}
