package DesignPatterns.ChainOfResponsibility.ConcreteHandler;

import DesignPatterns.ChainOfResponsibility.Constants.LogLevel;
import DesignPatterns.ChainOfResponsibility.Handler.LogHandler;

public class ErrorLogHandler implements LogHandler {

    LogHandler nextHandler;
    public ErrorLogHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void setNextLogger(LogHandler nextHandler) {
            this.nextHandler = nextHandler;
    }

    @Override
    public void writeLog(LogLevel logLevel, String s) {

        if (LogLevel.ERROR.equals(logLevel))
            System.out.println("ERROR : " + s);
        else if (nextHandler != null)
            nextHandler.writeLog(logLevel, s);
    }
}
