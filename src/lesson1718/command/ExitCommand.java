package lesson1718.command;

public class ExitCommand extends Command {
    @Override
    String name() {
        return "Exit";
    }

    String getString(){
        return null;
    }
    @Override
    boolean execute(String string) {
        System.out.println("ExitCommand");
        System.exit(0);
        return true;
    }

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }
}
