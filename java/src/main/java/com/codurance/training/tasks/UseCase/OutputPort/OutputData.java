package com.codurance.training.tasks.UseCase.OutputPort;

import java.util.List;

public class OutputData implements OutputPort{
    private final List<String> result;
    public OutputData(List<String> result) {
        this.result = result;
    }
    @Override
    public List<String> getOutputData() {
        return result;
    }
}
