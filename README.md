**HW1**
1. Create a `Command` interface and extract all commands from the program to implement the interface.
   - Command (Interface)
   - AddCommand
   - ErrorCommand
   - HelpCommand
   - ShowCommand
   - UncheckCommand
   - CheckCommand

2. Create concrete class `Project` to replace the variable `Map<String, List<Task>>`.

**HW2**
1. Create class `ConsoleInput` and `ConsoleOutput` to read and write message.

2. Create class `Controller` and `Presenter` to handle the console input and output.

3. Create Interfaces `InputPort` and `OutputPort` to pass input and output between Interface Adapter Layer and Use Case Layer.

4. Create class `CommandExecutor` to invoke commands.

**HW3**
1. Extract class `Tasks` and `Projects` to Entity Package.

2. Create record `ProjectName` in Entity Package.

**HW4**
1. Create record `TaskId` in Entity Package.

2. Create `UseCaseInteractor` and implement `InputBoundary`.

3. Add Collections.unmodifiableList() in Projects class and Tasks class avoid to break encapsulation.

**HW5**
1. Apply DDD tactical designs to the entities layer.

2. Enforce aggregate invariants by implementing ReadOnly subtypes for Project and Task.

3. Create class `ReadOnlyTask` and `ReadOnlyProject`.

**HW6**
1. Remove class `Tasks` and interface `Command`, use switch case to invoke commands.

2. Divide class `AddCommand` to `AddProjectService` and `AddTaskService`

3. Merge `CheckCommand` and `UncheckCommand` to class `SetDoneUseService`

4. Implement Use Case Input: `AddProjectInput`, `AddTaskInput`, `SetDoneInput` and `ErrorInput`

5. Remove `UseCaseInteractor`, use `Command` invoke services.

6. Implement `ProjectsRepository`.

7. Refactor `ShowCommand`, create `ShowInput`, `ShowOutput`, `ShowConsolePresenter`, interface `ShowUseCase`.

8. Create DTO Object : `ProjectsDto`, `ProjectDto`, `TaskDto`.

9. Create Mapper to convert DTO : `ProjectsMapper` `ProjectMapper`, `TaskMapper`.

(5/8)
1. Add and implement Interface `ErrorUseCase`, `HelpUseCase` and `HelpPresenter`, and use HelpDto pass data.

2. Main Component DI UseCases to Controller.

#Test Case can not work, need to fix.

(6/13)

#Fix test case.
