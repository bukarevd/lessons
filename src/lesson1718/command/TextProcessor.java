package lesson1718.command;

import java.util.Scanner;

// Реализация комманды(process, repeate, cancel, exit)
public class TextProcessor {
    private CommandsHistory history = new CommandsHistory();
    final String PROCESS = "process";
    final String CANCEL = "cancel";
    final String REPEATE = "repeate";
    final String EXIT = "exit";
    String string = "";
    String stringLog = "";

    public void executeCommand(Command command) {
        if (command.execute(stringLog)) {
            if (command instanceof ProcessCommand)
                history.add(command);
            else if (command instanceof RepeateCommand)
                history.repeateCommand(command);
        } else if (!history.isEmpty()) {
            history.delete();
        } else System.out.println("Операций нет");
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            string = in.nextLine();
//            if (string.equals(PROCESS)) {
//                executeCommand(new ProcessCommand(this));
//            }else stringLog+=string + "\n";

            switch (string) {
                case "process":
                    executeCommand(new ProcessCommand(this));
                    stringLog = "";
                    break;
                case "exit":
                    executeCommand(new ExitCommand(this));
                    break;
                case "cancel":

                    executeCommand(new CancelCommand(this));
                    break;
                case "repeate":
                    string = "";
                    executeCommand(new RepeateCommand(this));
                    break;
                default:
                    stringLog += string + "\n";
                    break;
            }
        }
    }


}
