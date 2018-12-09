package lesson1718.command;

import java.io.*;
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
        ArrayList<Command> CommandList= CommandsHistory.getHistory();
        File file = new File("command.txt");
        String newFileString = "";
        try(OutputStream out = new FileOutputStream(file, false)) {
            for (int i = 0; i < CommandList.size() - 1; i++){
                newFileString += CommandList.get(i).getString();
            }
            out.write(newFileString.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public CancelCommand(TextProcessor processor) {
        super(processor);
    }
}
