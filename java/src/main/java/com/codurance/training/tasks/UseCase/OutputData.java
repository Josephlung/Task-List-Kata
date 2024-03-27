package com.codurance.training.tasks.UseCase;

import java.util.List;

public class OutputData{
    private final List<String> result;
    public OutputData(List<String> result) {
        this.result = result;
    }
    public List<String> getOutputResult() {
        return result;
    }
}
