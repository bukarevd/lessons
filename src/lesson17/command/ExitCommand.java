package lesson17.command;

public class ExitCommand extends Command {
    @Override
    String name() {
        return "Exit";
    }

    @Override
    boolean execute() {
        System.out.println("ExitCommand");
        return true;
    }

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }
}
