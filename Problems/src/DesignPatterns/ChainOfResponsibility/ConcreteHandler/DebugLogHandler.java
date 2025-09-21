package DesignPatterns.ChainOfResponsibility.ConcreteHandler;

import DesignPatterns.ChainOfResponsibility.Constants.LogLevel;
import DesignPatterns.ChainOfResponsibility.Handler.LogHandler;

public class DebugLogHandler implements LogHandler {

    LogHandler nextHandler;
    public DebugLogHandler(LogHandler nextHandler) {
       this.nextHandler = nextHandler;
    }

    @Override
    public void setNextLogger(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void writeLog(LogLevel logLevel, String s) {

        if (LogLevel.DEBUG.equals(logLevel))
            System.out.println("DEBUG : " + s);
        else if (nextHandler != null)
            nextHandler.writeLog(logLevel, s);
    }
}
