package lesson1718.command;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class RepeateCommand extends Command {

    @Override
    boolean execute(String string) {
        File file = new File("command.txt");
        try(OutputStream out = new FileOutputStream(file, true)){
            out.write(string.getBytes());
        }catch(IOException e){
            e.getMessage();
        }
        return true;
    }

    String getString(){
        return this.string;
    }
    public RepeateCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "repeate";
    }
}
