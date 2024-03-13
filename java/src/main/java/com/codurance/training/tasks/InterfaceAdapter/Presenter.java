package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.UseCase.CommandInteractor;
import com.codurance.training.tasks.UseCase.OutputPort.OutputPort;

public class Presenter {
    private final CommandInteractor commandInteractor;
    public Presenter(CommandInteractor commandInteractor) {
        this.commandInteractor = commandInteractor;
    }

    public OutputPort getOutputData() {
        return commandInteractor.getResult();
    }
}
