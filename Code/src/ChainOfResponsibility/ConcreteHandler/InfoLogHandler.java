package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Constants.LogLevel;
import ChainOfResponsibility.Handler.LogHandler;

public class InfoLogHandler implements LogHandler {
    LogHandler nextHandler;
    public InfoLogHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void setNextLogger(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void writeLog(LogLevel logLevel, String s) {

        if (LogLevel.INFO.equals(logLevel))
            System.out.println("INFO : " + s);
        else if (nextHandler != null)
            nextHandler.writeLog(logLevel, s);
    }
}
