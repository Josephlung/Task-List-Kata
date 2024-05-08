package com.codurance.training.tasks.UseCase.Service;

import com.codurance.training.tasks.UseCase.Port.In.Projects.Error.ErrorInput;
import com.codurance.training.tasks.UseCase.Port.In.Projects.Error.ErrorUseCase;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.io.PrintWriter;

import static java.lang.String.format;

public class ErrorService implements ErrorUseCase {
    private final PrintWriter out;
    public ErrorService(PrintWriter out) {
        this.out = out;
    }

    @Override
    public CqrsOutput execute(ErrorInput input) {
        StringBuilder sb = new StringBuilder();
        out.print(format("I don't know what the command \"%s\" is.", input.commandLine));
        out.print("\r\n");
        return  CqrsOutput.create().fail().setMessage(out.toString());
    }
}
