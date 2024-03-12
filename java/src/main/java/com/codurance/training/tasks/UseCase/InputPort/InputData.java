package com.codurance.training.tasks.UseCase.InputPort;

public class InputData implements InputPort{

    String inputData;
    public  InputData(String inputData) {
        this.inputData = inputData;
    }
    @Override
    public String getInputData() {
        return inputData;
    }
}
