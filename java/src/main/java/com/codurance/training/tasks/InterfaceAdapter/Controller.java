package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.UseCase.InputPort.InputData;
import com.codurance.training.tasks.UseCase.InputPort.InputPort;
import com.codurance.training.tasks.UseCase.OutputPort.OutputData;
import com.codurance.training.tasks.UseCase.OutputPort.OutputPort;

import java.util.List;

public class Controller {
    private final CommandExecutor commandExecutor;
    public Controller(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public OutputPort execute(String commandLine) {
        InputPort inputPort = new InputData(commandLine);
        return new OutputData(commandExecutor.execute(inputPort));
    }
}
