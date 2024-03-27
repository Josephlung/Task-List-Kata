package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.UseCase.InputBoundary.InputBoundary;
import com.codurance.training.tasks.UseCase.InputData;
import com.codurance.training.tasks.UseCase.OutputData;

public class Controller {
    private final InputBoundary useCaseInteractor;
    public Controller(InputBoundary useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    public OutputData execute(String commandLine) {
        InputData inputData = new InputData(commandLine);
        return new OutputData(useCaseInteractor.execute(inputData));
    }
}
