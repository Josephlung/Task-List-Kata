package com.codurance.training.tasks.UseCase.Commands;

import java.util.List;

public interface Command {

    List<String> executeCommand(String command);
}
