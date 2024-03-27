package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.UseCase.OutputData;

import java.util.List;

public class Presenter {
    private final OutputData outputData;
    public Presenter(OutputData outputData) {
        this.outputData = outputData;
    }

    public List<String> getResult() {
        return outputData.getOutputResult();
    }
}
