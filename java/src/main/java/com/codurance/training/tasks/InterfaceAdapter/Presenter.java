package com.codurance.training.tasks.InterfaceAdapter;

import com.codurance.training.tasks.UseCase.OutputPort.OutputPort;
import java.util.List;

public class Presenter {
    private final OutputPort outputData;
    public Presenter(OutputPort outputData) {
        this.outputData = outputData;
    }

    public List<String> getResult() {
        return outputData.getOutputResult();
    }
}
