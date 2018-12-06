package lesson17.command;

import java.util.Scanner;

public class TextProcessor {
    private CommandsHistory history = new CommandsHistory();
    final String PROCESS = "process";

    public void execiteCommand(Command command) {
        if (command.execute()) {
            history.add(command);
        }
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
//            if (in.nextLine().equals(PROCESS)){
//                execiteCommand(new ProcessCommand(this));
//            }
            switch (in.nextLine()) {
                case "process":
                    execiteCommand(new ProcessCommand(this));
                    break;
                case "exit":
                    execiteCommand(new ExitCommand(this));
                    break;

            }
        }
    }
}
