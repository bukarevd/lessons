package lesson17.command;

public class ProcessCommand extends Command {
    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        System.out.println("реализация process");
        // Реализация комманды(process, repeate, cancel, exit)
        return true;
    }
}
