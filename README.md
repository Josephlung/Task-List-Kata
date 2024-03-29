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
