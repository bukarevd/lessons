package lesson1718.command;

import java.util.ArrayList;

public class CancelCommand extends Command {
    @Override
    String name() {
        return "Cancel";
    }
    String getString(){
        return null;
    }

    @Override
    boolean execute(String string) {
        System.out.println(CommandsHistory.getHistory());
        return false;
    }

    public CancelCommand(TextProcessor processor) {
        super(processor);
    }
}
