package lesson17.command;

import java.util.Stack;

public class CommandsHistory {
    private Stack<Command> history = new Stack<>();

    public void add(Command command){
        history.push(command);
    }

    public void delete(){
        history.pop();
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }
}
