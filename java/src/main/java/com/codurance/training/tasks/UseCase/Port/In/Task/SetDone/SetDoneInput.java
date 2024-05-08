package com.codurance.training.tasks.UseCase.Port.In.Task.SetDone;

import tw.teddysoft.ezddd.core.usecase.Input;

public class SetDoneInput implements Input {
    public String projectsId;
    public String taskId;
    public boolean done;
}
