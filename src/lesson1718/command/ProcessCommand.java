package lesson1718.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProcessCommand extends Command {
    private TextProcessor processor;
    String string;


    public ProcessCommand(TextProcessor processor) {
        super(processor);
        this.processor = processor;
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    public String getString(){
        return this.string;
    }

    @Override
    boolean execute(String string) {
        this.string = string;
        System.out.println(string);
        File file = new File("command.txt");
        try(OutputStream out = new FileOutputStream(file, true)){
            out.write(string.getBytes());
        }catch(IOException e){
            e.getMessage();
        }
//        processor.string = string;
        return true;
    }
}
