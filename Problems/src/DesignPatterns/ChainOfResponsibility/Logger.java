package DesignPatterns.ChainOfResponsibility;

import DesignPatterns.ChainOfResponsibility.ConcreteHandler.DebugLogHandler;
import DesignPatterns.ChainOfResponsibility.ConcreteHandler.ErrorLogHandler;
import DesignPatterns.ChainOfResponsibility.ConcreteHandler.InfoLogHandler;
import DesignPatterns.ChainOfResponsibility.ConcreteHandler.WarnLogHandler;
import DesignPatterns.ChainOfResponsibility.Constants.LogLevel;
import DesignPatterns.ChainOfResponsibility.Handler.LogHandler;

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
