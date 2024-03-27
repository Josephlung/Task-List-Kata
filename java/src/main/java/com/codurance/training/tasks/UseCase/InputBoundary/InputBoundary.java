package com.codurance.training.tasks.UseCase.InputBoundary;

import com.codurance.training.tasks.UseCase.InputData;

import java.util.List;

public interface InputBoundary {
    List<String> execute(InputData inputData);
}
