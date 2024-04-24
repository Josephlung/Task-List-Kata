package com.codurance.training.tasks.UseCase.Service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HelpService {
    private final PrintWriter out;
    public HelpService(PrintWriter out) {
        this.out = out;
    }
    public void execute() {
        out.print("Commands:\r\n");
        out.print("  show\r\n");
        out.print("  add project <project name>\r\n");
        out.print("  add task <project name> <task description>\r\n");
        out.print("  check <task ID>\r\n");
        out.print("  uncheck <task ID>\r\n");
        out.print("\r\n");
    }
}
