package lesson26;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;

import java.util.Date;
import java.util.logging.*;

public class Logged {
    //    создание логгера
    private static final Logger LOGGER = Logger.getLogger(Logged.class.getName());

    static {
//        установка уровня логирования
        LOGGER.setLevel(Level.INFO);
    }

    public static void main(String[] args) {
//
        LOGGER.info("Started with args: " + Arrays.toString(args));
        try {
            int result = 3 / 0;
        } catch (Exception e) {
            LOGGER.severe("Fatal error: " + e.getMessage());
        }
    }
}

class LoggedFile {
    private static final Logger LOGGER = Logger.getLogger(Logged.class.getName());

    static {
        try {
            LOGGER.addHandler(new FileHandler("logged.log.xml"));

            FileHandler fileHandler = new FileHandler("logged.log");
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.warning("Can't create file");
        }
    }

    public static void main(String[] args) {
//
        LOGGER.info("Started with args: " + Arrays.toString(args));
        try {
            int result = 3 / 0;
        } catch (Exception e) {
            LOGGER.severe("Fatal error: " + e.getMessage());
        }
    }
}

//class MyFormatter extends Formatter {
//
//   private final static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>(){
//       @Override
//       protected DateFormat initialValue() {
//           return
//       }
//   };
//
//
//    @Override
//    public String format(LogRecord record) {
////        свой формат записи
//        StringBuilder sb = new StringBuilder();
//        sb.append("[").append(formatTime(record.getMillis())).append("]");
//        sb.append("\n");
//        sb.append("[").append(record.getLevel()).append("]");
//        sb.append(record.getMessage());
//        return  sb.toString();
//    }
//
//    private String formatTime(long mils){
//        return dateFormat.get().format(new Date(mils));
//    }
//}



