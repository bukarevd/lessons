package lesson1718.command;

abstract public class Command {
    abstract String name();

    abstract boolean execute(String string);

    abstract String getString();

    String string;


    protected TextProcessor processor;

    public Command(TextProcessor processor) {
        this.processor = processor;
    }

}
