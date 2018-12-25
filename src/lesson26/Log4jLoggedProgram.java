package lesson26;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

//public class Log4jLoggedProgram {
//    //    Log4j
//    private static final Logger LOGGER = Logger.getLogger(Log4jLoggedProgram.class);
//
//    public static void main(String[] args) {
//        LOGGER.info("Started with args: " + Arrays.toString(args));
//        try {
//            int result = 3 / 0;
//        } catch (Exception e) {
//            LOGGER.error("Fatal error: " + e.getMessage());
//        }
//    }
//}

//slf4j

class Slf4jLoggerProgram{
    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jLoggerProgram.class);

    public static void main(String[] args) {
        LOGGER.info("Started with args: " + Arrays.toString(args));
        try {
            int result = 3 / 0;
        } catch (Exception e) {
            LOGGER.error("Fatal error: " + e.getMessage());
        }
    }

}
