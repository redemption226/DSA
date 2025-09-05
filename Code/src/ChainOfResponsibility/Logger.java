package ChainOfResponsibility;

import ChainOfResponsibility.ConcreteHandler.DebugLogHandler;
import ChainOfResponsibility.ConcreteHandler.ErrorLogHandler;
import ChainOfResponsibility.ConcreteHandler.InfoLogHandler;
import ChainOfResponsibility.ConcreteHandler.WarnLogHandler;
import ChainOfResponsibility.Constants.LogLevel;
import ChainOfResponsibility.Handler.LogHandler;

public class Logger {

    public static void main(String[] args) {
//        LogHandler errorLogHandler = new ErrorLogHandler();
//        LogHandler warnLogHandler = new WarnLogHandler();
//        LogHandler infoLogHandler = new InfoLogHandler();
//        LogHandler debugLogHandler = new DebugLogHandler();
//
//        infoLogHandler.setNextLogger(debugLogHandler);
//        warnLogHandler.setNextLogger(infoLogHandler);
//        errorLogHandler.setNextLogger(warnLogHandler);

        LogHandler logger = new ErrorLogHandler(new WarnLogHandler(new InfoLogHandler(new DebugLogHandler(null))));

        logger.writeLog(LogLevel.DEBUG, "Hi");
        logger.writeLog(LogLevel.INFO, "Hi");
        logger.writeLog(LogLevel.ERROR, "Hi");
        logger.writeLog(LogLevel.WARN, "Hi");

    }

}
