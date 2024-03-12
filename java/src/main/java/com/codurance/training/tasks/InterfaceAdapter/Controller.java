package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.UseCase.CommandInteractor;
import com.codurance.training.tasks.UseCase.InputPort.InputData;
import com.codurance.training.tasks.UseCase.InputPort.InputPort;

public class Controller {
    private final CommandInteractor commandInteractor;
    public Controller() {
        commandInteractor = new CommandInteractor();
    }

    public void execute(String commandLine) {
        InputPort inputPort = new InputData(commandLine);
        commandInteractor.execute(inputPort);
    }
}
