package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;

import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.InterfaceAdapter.presenter.HelpConsolePresenter;
import com.codurance.training.tasks.InterfaceAdapter.presenter.ShowConsolePresenter;
import com.codurance.training.tasks.Persistence.TaskListRunner;
import com.codurance.training.tasks.UseCase.Port.Out.ProjectsRepository;
import com.codurance.training.tasks.InterfaceAdapter.Out.Repository.ProjectInMemoryRepository;
import com.codurance.training.tasks.UseCase.Service.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public final class ApplicationTest {
    public static final String PROMPT = "> ";
    private final PipedOutputStream inStream = new PipedOutputStream();
    private final PrintWriter inWriter = new PrintWriter(inStream, true);

    private final PipedInputStream outStream = new PipedInputStream();
    private final BufferedReader outReader = new BufferedReader(new InputStreamReader(outStream));

    private Thread applicationThread;

    public ApplicationTest() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new PipedInputStream(inStream)));
        PrintWriter out = new PrintWriter(new PipedOutputStream(outStream), true);
        ProjectsRepository repository = new ProjectInMemoryRepository();
        repository.save(new Projects(TaskListRunner.DEFAULT_PROJECTS_ID));
        var showUseCase = new ShowService(repository);
        var showPresenter = new ShowConsolePresenter(out);
        var addProjectUseCase = new AddProjectService(repository);
        var addTaskUseCase = new AddTaskService(repository, out);
        var setDoneUseCase = new SetDoneService(repository, out);
        var helpUseCase = new HelpService(new HelpConsolePresenter(out));
        var errorUseCase = new ErrorService(out);

        TaskListRunner taskListRunner = new TaskListRunner(
                in,
                out,
                showUseCase,
                showPresenter,
                addProjectUseCase,
                addTaskUseCase,
                setDoneUseCase,
                helpUseCase,
                errorUseCase);
        applicationThread = new Thread(taskListRunner);
    }

    @Before public void
    start_the_application() {
        applicationThread.start();
    }

    @After public void
    kill_the_application() throws IOException, InterruptedException {
        if (!stillRunning()) {
            return;
        }

        Thread.sleep(1000);
        if (!stillRunning()) {
            return;
        }

        applicationThread.interrupt();
        throw new IllegalStateException("The application is still running.");
    }

    @Test(timeout = 1000) public void
    it_works() throws IOException {
        execute("show");

        execute("add project secrets");
        execute("add task secrets Eat more donuts.");
        execute("add task secrets Destroy all humans.");

        execute("show");
        readLines(
                "secrets",
                "    [ ] 1: Eat more donuts.",
                "    [ ] 2: Destroy all humans.",
                ""
        );

        execute("add project training");
        execute("add task training Four Elements of Simple Design");
        execute("add task training SOLID");
        execute("add task training Coupling and Cohesion");
        execute("add task training Primitive Obsession");
        execute("add task training Outside-In TDD");
        execute("add task training Interaction-Driven Design");

        execute("check 1");
        execute("check 3");
        execute("check 5");
        execute("check 6");

        execute("show");
        readLines(
                "secrets",
                "    [x] 1: Eat more donuts.",
                "    [ ] 2: Destroy all humans.",
                "",
                "training",
                "    [x] 3: Four Elements of Simple Design",
                "    [ ] 4: SOLID",
                "    [x] 5: Coupling and Cohesion",
                "    [x] 6: Primitive Obsession",
                "    [ ] 7: Outside-In TDD",
                "    [ ] 8: Interaction-Driven Design",
                ""
        );

        // Added by Teddy to verify error handling messages
        execute("add task DDD learn CA.");
        readLines(
                "Could not find a project with the name \"DDD\"."
        );

        execute("check 99");
        readLines(
                "Could not find a task with an ID of 99."
        );

        execute("help");
        readLines(
                "Commands:",
                "  show",
                "  add project <project name>",
                "  add task <project name> <task description>",
                "  check <task ID>",
                "  uncheck <task ID>",
                ""
        );

        execute("not-a-command");
        readLines(
                "I don't know what the command \"not-a-command\" is."
        );

        execute("quit");

    }

    private void execute(String command) throws IOException {
        read(PROMPT);
        write(command);
    }

    private void read(String expectedOutput) throws IOException {
        int length = expectedOutput.length();
        char[] buffer = new char[length];
        outReader.read(buffer, 0, length);
        assertThat(String.valueOf(buffer), is(expectedOutput));
    }

    private void readLines(String... expectedOutput) throws IOException {
        for (String line : expectedOutput) {
            read(line + lineSeparator());
        }
    }

    private void write(String input) {
        inWriter.println(input);
    }

    private boolean stillRunning() {
        return applicationThread != null && applicationThread.isAlive();
    }
}
