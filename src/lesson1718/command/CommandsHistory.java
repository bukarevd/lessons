package lesson1718.command;


import java.util.ArrayList;
import java.util.Arrays;

public class CommandsHistory {
    private static ArrayList<Command> history = new ArrayList<>();

    public void add(Command command) {
        history.add(command);
        System.out.println(Arrays.toString(history.toArray()));
    }

    public void delete() {
        history.remove(history.size() - 1);
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void setHistory(ArrayList<Command> history) {
        this.history = history;
    }

    public static ArrayList<Command> getHistory(){
        return history;
    }

    public void repeateCommand(Command command) {
        Command command1 = history.get(history.size() -1);
        command.string =command1.getString();
        command.execute(command1.getString());
        add(command);
    }

}
